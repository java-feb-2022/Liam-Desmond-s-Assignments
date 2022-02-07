package com.liam.ninjagoldgame;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	@RequestMapping("/")
    public String index(HttpSession session, Model model) {


		if(session.getAttribute("gold") != null && session.getAttribute("log") != null) {
			Integer gold = (Integer) session.getAttribute("gold");
			@SuppressWarnings("unchecked")
			ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");
			model.addAttribute("log", log);
			model.addAttribute("gold", gold);
	        return "index.jsp";
		}
		else {
			ArrayList<String> log = new ArrayList<String>();
			int gold = 0;
			session.setAttribute("gold", gold);
			session.setAttribute("log", log);

	        return "index.jsp";
			
		}


    }
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
    public String result(HttpSession session, @RequestParam("hidden") String hidden, Model model) {
		Integer gold = (Integer) session.getAttribute("gold");

		@SuppressWarnings("unchecked")
		ArrayList<String> log = (ArrayList<String>) session.getAttribute("log");


		Random f = new Random();
		int lowf = 10;
		int highf = 20;
		int resultf = f.nextInt(highf-lowf) + lowf;
		
		Random c = new Random();
		int lowc = 5;
		int highc = 10;
		int resultc = c.nextInt(highc-lowc) + lowc;
		
		Random h = new Random();
		int lowh = 2;
		int highh = 5;
		int resulth = h.nextInt(highh-lowh) + lowh;
		
		Random cas = new Random();
		int lowcas = -50;
		int highcas = 50;
		int resultcas = cas.nextInt(highcas-lowcas) + lowcas;
		

			if(hidden.equals("farm")) {
				session.setAttribute("gold", gold + resultf);
				log.add("gain of " + resultf + " gold");
		        return "redirect:/";
			}
			if(hidden.equals("house")) {
				session.setAttribute("gold", gold + resulth);
				log.add("gain of " + resulth + " gold");
		        return "redirect:/";
			}

			if(hidden.equals("casino")) {
				session.setAttribute("gold", gold + resultcas);
				if(resultcas < 0) {
					log.add("loss of " + resultcas + " gold");
			        return "redirect:/";
				}
				else {
					log.add("gain of " + resultcas + " gold");
			        return "redirect:/";
				}

			}

			if(hidden.equals("cave")) {
				session.setAttribute("gold", gold + resultc);
				log.add("gain of " + resultc + " gold");
		        return "redirect:/";
			}
			
	        return "index.jsp";
		}

}
