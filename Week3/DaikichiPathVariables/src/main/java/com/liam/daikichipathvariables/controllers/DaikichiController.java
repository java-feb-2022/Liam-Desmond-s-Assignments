package com.liam.daikichipathvariables.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiController {
	
	@RequestMapping("/welcome")
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
	
	
	@RequestMapping("/daikichi/travel/{place}")
	public String travel(@PathVariable("place") String place) {
		return "Congratulations! You will soon travel to " + place + "!";
		
	}
	
	@RequestMapping("/daikichi/lotto/{number}")
	public String lotto(@PathVariable("number") int number) {
		if (number % 2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers.";
		}
		
		return "You have enjoyed the fruits of your labor, but now is a great time to spend with family and friends.";
		
	}
	


}
