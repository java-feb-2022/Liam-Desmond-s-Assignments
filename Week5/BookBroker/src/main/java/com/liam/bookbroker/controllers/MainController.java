package com.liam.bookbroker.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.liam.bookbroker.models.Book;
import com.liam.bookbroker.models.LoginUser;
import com.liam.bookbroker.models.User;
import com.liam.bookbroker.services.BookService;
import com.liam.bookbroker.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private BookService mainServ;
	


	
	// DashBoard
	@GetMapping("/dashboard") // All Serfs
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		}

		Long userId = (Long) session.getAttribute("user_id");
		User userLog = userServ.getUser(userId);
		model.addAttribute("userLog", userLog);
		
		model.addAttribute("allSerfs", mainServ.getAll());
		
		return "dashboard.jsp";
	}
	
	
	// Show One Serf
	@GetMapping("/serf/show/{id}")
	public String showOneSerf(@PathVariable("id") Long id, @ModelAttribute("book") Book book, Model model, HttpSession session, BindingResult result) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		Long userId = (Long) session.getAttribute("user_id");

		model.addAttribute("userLog", userServ.getUser(userId));
		model.addAttribute("book", mainServ.getOne(id));
		return "showSerf.jsp";
	}
	


	// Create Serf Form
	@GetMapping("/newSerfForm")
	public String newSerfForm(@ModelAttribute("bookForm") Book book, HttpSession session, Model model) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("user_id");
		User userLog = userServ.getUser(userId);
		model.addAttribute("userLog", userLog);
		return "createSerf.jsp";
	}

	// Create Serf Process
	@PostMapping("/create/serf")
	public String createSerf(@Valid @ModelAttribute("bookForm") Book newSerf, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			 return "createSerf.jsp";
		}
		
		Long userId = (Long) session.getAttribute("user_id");
		newSerf.setOwner(userServ.getUser(userId));
		
		mainServ.createOne(newSerf);
		return "redirect:/dashboard";
	}
	
	
	// Edit Serf Form
	@GetMapping("/edit/serf/{id}")
	public String editSerfForm(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		Long userId = (Long) session.getAttribute("user_id");
		User userLog = userServ.getUser(userId);
		model.addAttribute("userLog", userLog);
		
		model.addAttribute("book", mainServ.getOne(id));
		return "editSerf.jsp";
		
	}
	
	// Edit Serf Process
	@PostMapping("/edit/serf/proc/{id}")
	public String updateSerf(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book serf, BindingResult result, @RequestParam("owner") User user, @RequestParam("borrower") User borrower, Model model, HttpSession session) {
		if (result.hasErrors()) {

			Long userId = (Long) session.getAttribute("user_id");
			User userLog = userServ.getUser(userId);
			
			model.addAttribute("userLog", userLog);
//			model.addAttribute("book", mainServ.getOne(id));
			return "editSerf.jsp";
		}
		serf.setOwner(user);
		serf.setBorrower(borrower);
		mainServ.updateOne(serf);
		return "redirect:/serf/show/{id}";
	}
	

	// Delete Serf
	@GetMapping("/delete/serf/{id}")
	public String deleteSerf(@PathVariable("id") Long id) {
		mainServ.deleteOne(id);
		return "redirect:/dashboard";
	}



	
//	 ____ ___                    
//	|    |   \______ ___________ 
//	|    |   /  ___// __ \_  __ \
//	|    |  /\___ \\  ___/|  | \/
//	|______//____  >\___  >__|   
//	             \/     \/       

	
	
	//////  NEW LOGIN/REG //////
	
   @GetMapping("/")
   public String loginPage(Model model) {
       model.addAttribute("newUser", new User());
       model.addAttribute("newLogin", new LoginUser());
       return "login.jsp";
   }
   
   // Create User Process
   @PostMapping("/registerUser")
   public String registerUser(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
   	userServ.register(newUser, result);
       if(result.hasErrors()) {
           model.addAttribute("newLogin", new LoginUser());
           return "login.jsp";
       }
       session.setAttribute("user_id", newUser.getId());
       return "redirect:/dashboard";
   }
   
   // Login User Process
   @PostMapping("/loginUser")
   public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
       User user = userServ.login(newLogin, result);
       if(result.hasErrors()) {
           model.addAttribute("newUser", new User());
           return "login.jsp";
       }
       session.setAttribute("user_id", user.getId());
       return "redirect:/dashboard";
   }
   
   // Show One User
   @GetMapping("/user/show/{id}")
   public String showUser(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		Long userId = (Long) session.getAttribute("user_id");
		model.addAttribute("userLog", userServ.getUser(userId));
   	model.addAttribute("user", userServ.getUser(id));
       return "showUser.jsp";
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
	
	
	
	
	
	// User M2M Serf Process
	@GetMapping("/borrow/{id}")
	public String RSVP(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		User borrower = userServ.getUser(userId);

		Book borrowed = mainServ.getOne(id);
		mainServ.addExtra(borrower, borrowed);
		
		return "redirect:/dashboard";
	}
	
	
	// User M2M Serf Process undo
	@GetMapping("/unborrow/{id}")
	public String unRSVP(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		User borrower = userServ.getUser(userId);

		Book borrowed = mainServ.getOne(id);
		mainServ.removeExtra(borrower, borrowed);
		
		return "redirect:/dashboard";
	}

}
