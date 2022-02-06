package com.liam.daikichiroutes.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DaikichiController {
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome!";
		
	}
	
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
		
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, and opportunity will arise, so be sure to be open to new ideas!";
		
	}

}
