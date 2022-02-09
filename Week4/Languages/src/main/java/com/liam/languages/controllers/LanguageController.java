package com.liam.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liam.languages.models.Language;
import com.liam.languages.services.LanguageService;


@Controller
public class LanguageController {
	
	@Autowired
	private LanguageService languageServ;
	
	// Get All
    @RequestMapping("/languages")
    public String index(@ModelAttribute("language") Language language, Model model) {
        List<Language> languages = languageServ.allLanguages();
        model.addAttribute("languages", languages);
        return "/languages/index.jsp";
    }
    
    // Get One
    @RequestMapping("/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Language language = languageServ.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/show.jsp";
    }
    
    // Create Form PAGE
    @RequestMapping("/languages/new")
    public String newLanguage(@ModelAttribute("language") Language language) {
        return "/languages/new.jsp";
    }

    // Create Processing
    @RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
    	
        if (result.hasErrors()) {
//            return "/languages/new.jsp";
            List<Language> languages = languageServ.allLanguages();
            model.addAttribute("languages", languages);
            return "/languages/index.jsp";
        } else {
        	languageServ.createLanguage(language);
            return "redirect:/languages";
        }
    }
    
    // Edit Form
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageServ.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/edit.jsp";
    }
    
    // Edit Processing
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
        	return "/languages/edit.jsp";

        } else {
        	languageServ.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    
    
    // Delete
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	languageServ.deleteLanguage(id);
        return "redirect:/languages";
    }

}
