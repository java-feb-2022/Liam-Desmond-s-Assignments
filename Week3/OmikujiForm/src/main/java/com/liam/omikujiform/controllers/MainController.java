package com.liam.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/omikuji/process")
	public String process(HttpSession session, @RequestParam("number") int number, @RequestParam("city") String city, @RequestParam("name") String name, @RequestParam("hobby") String hobby, @RequestParam("thing") String thing, @RequestParam("nice") String nice) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("nice", nice);
	    return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String confirmationPage(HttpSession session, Model model){
		int number = (Integer) session.getAttribute("number");
		String city = (String) session.getAttribute("city");
		String name = (String) session.getAttribute("name");
		String hobby = (String) session.getAttribute("hobby");
		String thing = (String) session.getAttribute("thing");
		String nice = (String) session.getAttribute("nice");
		
		model.addAttribute("number", number);
		model.addAttribute("city", city);
		model.addAttribute("name", name);
		model.addAttribute("hobby", hobby);
		model.addAttribute("thing", thing);
		model.addAttribute("nice", nice);

	        
	    return "show.jsp";
	}

}
