package com.liam.productsandcategories2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liam.productsandcategories2.models.Category;
import com.liam.productsandcategories2.models.Product;
import com.liam.productsandcategories2.repositories.CategoryRepository;
import com.liam.productsandcategories2.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository mainRepo;
	
	@Autowired
	private CategoryRepository categRepo;
	
	public List<Product> getAll() {
        return mainRepo.findAll();
    }
    
    public Product getOne(Long id) {
    	return mainRepo.findById(id).orElse(null);

    }
    
    // Get all Serfs that Main doesn't belong to
    public List<Product> findByCategoriesNotContains(Category category) {
    	return mainRepo.findByCategoriesNotContains(category);
    }

    public Product create(Product dommod) {
        return mainRepo.save(dommod);
    }
    


    
    public Product update(Product dommod) {
        return mainRepo.save(dommod);
    }

    	

    
    public void delete(Long Id) {
    	mainRepo.deleteById(Id);
    	}
    
    
    // New Serf
    
    public Category createSerf(Category dommod) {
        return categRepo.save(dommod);
    }
    
    // Find all Serfs
	public List<Category> getAllSerfs() {
        return categRepo.findAll();
    }
	
	// Delete Serf
    public void deleteSerf(Long Id) {
    	categRepo.deleteById(Id);
    }
    
    // Get one Serf
    public Category getOneSerf(Long id) {
    	return categRepo.findById(id).orElse(null);

    }
    
    // Get all Mains that Serf doesn't belong to
    public List<Category> findByProductsNotContains(Product product) {
    	return categRepo.findByProductsNotContains(product);
    }
    
    // Edit Serf
    public Category updateSerf(Category dommod) {
        return categRepo.save(dommod);
    }
    
    
    // MANY TO MANY
    
    
//	// Add Serf to Main
//	public void addSerfToMain(Category category, Product product) {
//		product.getCategories().add(category);
//		
////		this.mainRepo.save(product);
//	}
//	
//
//	
//	
//    
//    
//	// Add Main to Serf
//	public void addMainToSerf(Product product, Category category) {
//		category.getProducts().add(product);
//
////		this.categRepo.save(category);
//	}
	


}
