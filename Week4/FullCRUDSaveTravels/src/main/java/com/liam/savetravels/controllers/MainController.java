package com.liam.savetravels.controllers;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.liam.savetravels.models.Expense;
import com.liam.savetravels.services.ExpenseService;

@Controller
public class MainController {
	
	
	@Autowired
	private ExpenseService expenseServ;
	
	@GetMapping("/")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		model.addAttribute("all", expenseServ.getAll());
		return "index.jsp";
	}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("one", expenseServ.getOne(id));
		
		return "show.jsp";
	}
	
	@GetMapping("/new")
	public String newPage(@ModelAttribute("expense") Expense expense) {
		return "create.jsp";
	}
	
	
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model ) {
		if (result.hasErrors()) {	
			model.addAttribute("all", expenseServ.getAll());
			return "create.jsp";
		}

		expenseServ.createOne(expense);
	    return "redirect:/";
	}
	
	@GetMapping("/editpage/{id}")
	public String editPage(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseServ.getOne(id));
		return "edit.jsp";
	}
	
	
	
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, @Valid @ModelAttribute("expense") Expense expense,  BindingResult result, Model model) {
		if (result.hasErrors()) {	
			model.addAttribute("expense", expenseServ.getOne(id));
			return "edit.jsp";
		}

		expenseServ.updateOne(expense);
		return "redirect:/show/{id}";
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {	
		expenseServ.deleteOne(id);
		return "redirect:/";
	}
	
	

}
