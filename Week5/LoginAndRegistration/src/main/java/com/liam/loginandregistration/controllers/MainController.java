package com.liam.loginandregistration.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.liam.loginandregistration.models.LoginUser;
import com.liam.loginandregistration.models.User;
import com.liam.loginandregistration.services.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userServ;
	
	@GetMapping("/")
	public String loginPage(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}
	

	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		}

		Long userId = (Long) session.getAttribute("user_id");
		User userLog = userServ.getUser(userId);
		model.addAttribute("userLog", userLog);
		return "dashboard.jsp";
	}



	// Create User Process
	@PostMapping("/registerUser")
	public String registerUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {
		userServ.register(newUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		}
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dashboard";
	}

	// Login User Process
	@PostMapping("/loginUser")
	public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {
		User user = userServ.login(newLogin, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		session.setAttribute("user_id", user.getId());
		return "redirect:/dashboard";
	}



	// Logout User
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	// Delete User
	@GetMapping("/delete/user/{id}")
	public String deleteSUser(@PathVariable("id") Long id) {
		userServ.deleteOne(id);
		return "redirect:/dashboard";
	}

}
