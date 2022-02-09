package com.liam.dojosandninjas2.controllers;

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

import com.liam.dojosandninjas2.models.Dojo;
import com.liam.dojosandninjas2.models.Ninja;
import com.liam.dojosandninjas2.services.DojoService;
import com.liam.dojosandninjas2.services.NinjaService;

@Controller
public class MainController {

	
	@Autowired
	private DojoService dojoServ;
	
	@Autowired
	private NinjaService ninjaServ;
	
	
	// Dashboard
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("dojos", dojoServ.getAll());
		return "index.jsp";
	}
	
	// Show Dojo
	@GetMapping("/dojo/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoServ.getOne(id));
		
		return "showDojo.jsp";
	}
	
	// Show Ninja
	@GetMapping("/ninja/{id}")
	public String showNinja(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ninja", ninjaServ.getOne(id));
		
		return "showNinja.jsp";
	}
	
	// Create Dojo Page
	@GetMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	// Create Dojo Processing
	@PostMapping("/dojo/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newDojo.jsp";
		}
		
		dojoServ.createOne(dojo);
		return "redirect:/";
	}
	
	// Create Ninja Page
	@GetMapping("/ninja/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoServ.getAll());
		return "newNinja.jsp";
	}
	
	// Create Ninja Processing
	@PostMapping("/ninja/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("dojos", dojoServ.getAll());
			return "newNinja.jsp";
		}
		
		ninjaServ.createOne(ninja);
		return "redirect:/";
	}
	
	// Edit Dojo Page
	@GetMapping("/dojo/editPage/{id}")
	public String editDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoServ.getOne(id));
		
		return "editDojo.jsp";
	}
	
	// Edit Dojo Processing
	@PutMapping("/dojo/update/{id}")
	public String updateDojo(@PathVariable("id") Long id, @Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "editDojo.jsp";
		}
		
		dojoServ.updateOne(dojo);
		return "redirect:/dojo/{id}";
	}
	
	
	// Edit Ninja Page
	@GetMapping("/ninja/editPage/{id}")
	public String editNinja(@PathVariable("id") Long id, Model model) {
		model.addAttribute("ninja", ninjaServ.getOne(id));
		model.addAttribute("dojos", dojoServ.getAll());
		return "editNinja.jsp";
	}
	
	// Edit Ninja Processing
	@PutMapping("/ninja/update/{id}")
	public String updateNinja(@PathVariable("id") Long id, @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("dojos", dojoServ.getAll());
			return "editNinja.jsp";
		}
		
		ninjaServ.updateOne(ninja);
		return "redirect:/ninja/{id}";
	}
	
	// Delete Dojo
	@GetMapping("/dojo/delete/{id}")
	public String deleteDojo(@PathVariable("id") Long id) {
		dojoServ.deleteOne(id);
		return "redirect:/";
	}
	
	// Delete Ninja
	@GetMapping("/ninja/delete/{id}")
	public String deleteNinja(@PathVariable("id") Long id) {
		ninjaServ.deleteOne(id);
		return "redirect:/";
	}
	
	
	
	
	
}
