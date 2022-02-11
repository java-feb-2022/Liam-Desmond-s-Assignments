package com.liam.productsandcategories2.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liam.productsandcategories2.models.Category;
import com.liam.productsandcategories2.models.CategoryProduct;
import com.liam.productsandcategories2.models.Product;
import com.liam.productsandcategories2.services.CategoryProductService;
import com.liam.productsandcategories2.services.ProductService;

@Controller
public class MainController {
	
	@Autowired
	private ProductService mainServ;
	
	@Autowired
	private CategoryProductService catprodServ;
	
	// Dashboard
	@GetMapping("/")
	public String index() {
		return "redirect:/products";
	}
	
	// Get All
    @GetMapping("/products")
    public String dashboard(@ModelAttribute("product") Product obj, Model model) {
        List<Product> everything = mainServ.getAll();
        model.addAttribute("products", everything);
        return "index.jsp";
    }
    
    // Get Main with Serfs
    @GetMapping("/products/show/{id}")
    public String show(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("categoryproduct") CategoryProduct catprod, BindingResult result) {
    	Product product = mainServ.getOne(id);
    	
    	List<Category> allOthers = mainServ.findByProductsNotContains(product);
//    	List<Category> allOthers = mainServ.getAllSerfs();
    	
    	
        model.addAttribute("categories", allOthers);
    	model.addAttribute("product", mainServ.getOne(id));
        return "show.jsp";
    }
    
    // Create Form PAGE
    @GetMapping("/products/new")
    public String newForm(@ModelAttribute("product") Product obj) {
        return "new.jsp";
    }

    // Create Processing
    @PostMapping("/create/product")
    public String create(@Valid @ModelAttribute("product") Product obj, BindingResult result, Model model) {
    	
        if (result.hasErrors()) {
        	
            List<Product> everything = mainServ.getAll();
            model.addAttribute("products", everything);
            return "new.jsp";
        } else {
        	mainServ.create(obj);
            return "redirect:/products";
        }
    }
    
    // Edit Form
    @GetMapping("/products/{id}/edit")
    public String editForm(@PathVariable("id") Long id, Model model) {
    	Product product = mainServ.getOne(id);
        model.addAttribute("product", product);
        return "edit.jsp";
    }
    
    // Edit Processing
    @PutMapping("/products/{id}")
    public String update(@Valid @ModelAttribute("product") Product obj, BindingResult result) {
        if (result.hasErrors()) {
        	return "edit.jsp";

        } else {
        	mainServ.update(obj);
            return "redirect:/products";
        }
    }
    
    
    // Delete
    @GetMapping("/products/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	mainServ.delete(id);
        return "redirect:/products";
    }
    
    // ONE:MANY ///////////////////
    
    // Serf form
    @GetMapping("/categories/new")
    public String newSerfForm(@ModelAttribute("category") Category obj, Model model) {
        List<Product> everything = mainServ.getAll();
        model.addAttribute("products", everything);
        return "newSerf.jsp";
    }
    
    // Create Serf Processing
    @PostMapping("/create/category")
    public String createSerf(@Valid @ModelAttribute("category") Category obj, BindingResult result, Model model) {
//    	Long productId = obj.getProduct().getId();
        if (result.hasErrors()) {
            List<Product> everything = mainServ.getAll();
            model.addAttribute("products", everything);
            return "newSerf.jsp";
        } else {
        	mainServ.createSerf(obj);
        	return "redirect:/products";
//            return String.format("redirect:/products/%s", obj.getProducts().getId());
        }
    }
    

    
    // Get one Serf with Mains
    @GetMapping("/categories/show/{id}")
    public String getOneSerf(@PathVariable("id") Long id, Model model, @ModelAttribute("categoryproduct") CategoryProduct catprod) {
    	Category serf = mainServ.getOneSerf(id);

    	List<Product> allOthers = mainServ.findByCategoriesNotContains(serf);
//    	List<Product> allOthers = mainServ.getAll();


    	model.addAttribute("category", serf);
        model.addAttribute("products", allOthers);
        return "showSerf.jsp";
    }
    
    // Edit Serf Form
    @GetMapping("/categories/edit/{id}")
    public String editSerfForm(@PathVariable("id") Long id, Model model) {
    	Product product = mainServ.getOne(id);
        model.addAttribute("product", product);
        return "editSerf.jsp";
    }
    
    // Edit Serf Processing
    @PutMapping("/categories/{id}")
    public String updateSerf(@Valid @ModelAttribute("product") Category obj, BindingResult result) {
        if (result.hasErrors()) {
        	return "editSerf.jsp";

        } else {
        	mainServ.updateSerf(obj);
            return "redirect:/categories";
        }
    }
    
    
    // Delete Serf
    @GetMapping("/categorys/{id}")
    public String destroySerf(@PathVariable("id") Long id) {
    	Category serf = mainServ.getOneSerf(id);
    	List<Product> products = serf.getProducts();
    	Product productId= mainServ.getOne(id);
    	mainServ.delete(id);
    	
    	return String.format("redirect:/products/%s", productId.getId());
//        return "redirect:/products";
    }
    
    
    
    
    // MANY TO MANY////////////////////////////////////////////////////////////////////////////
    
    
	// Add Serf to Main
    @PostMapping("/addSerfToMain/{id}")
	public String addSerftoMain(@PathVariable("id") Long id, @RequestParam("category") Long serfId, @ModelAttribute("categoryproduct") CategoryProduct catprod) {


		catprodServ.createOne(catprod);
		return "redirect:/products/show/" + id;
	}
	

    
    
	// Add Main to Serf
    @PostMapping("/addMainToSerf/{id}")
	public String addMainToSerf(@PathVariable("id") Long id, @RequestParam("product") Long mainId, @ModelAttribute("categoryproduct") CategoryProduct catprod) {


		catprodServ.createOne(catprod);
		return "redirect:/categories/show/" + id;
	}
	


}
