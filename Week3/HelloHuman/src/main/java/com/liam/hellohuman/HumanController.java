package com.liam.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {
	
	@RequestMapping("/")
	public String dojo(@RequestParam(value="name", required=false) String name, @RequestParam(value="last", required=false) String last) {
		if (name == null) {
			return "<html>" + "<h1>Hello Human!</h1><p>Welcome to Spring Boot!</p>";
		}
		if (last == null) {
			return "<html>" + "<h1>Hello, " + name + "!</h1><p>Welcome to Spring Boot!</p>" + "<a href=/>Go back</a></html>";
		}
		else {
			return "<html>" + "<h1>Hello, " + name + " " + last + "!</h1><p>Welcome to Spring Boot!</p>" + "<a href=/>Go back</a></html>";
		}
	}
	




}
