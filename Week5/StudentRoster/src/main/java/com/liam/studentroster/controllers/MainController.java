package com.liam.studentroster.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.liam.studentroster.models.Dorm;
import com.liam.studentroster.models.Student;
import com.liam.studentroster.services.DormService;
import com.liam.studentroster.services.StudentService;

@Controller
public class MainController {
	
	@Autowired
	private DormService dormServ;
	
	@Autowired
	private StudentService studentServ;
	
	// Dashboard
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("dorms", dormServ.getAll());
		return "index.jsp";
	}
	
	// Show Dorm
	@GetMapping("/dorm/{id}")
	public String showDorm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("students", studentServ.getAll());
		model.addAttribute("dorm", dormServ.getOne(id));
		
		return "showDorm.jsp";
	}
	
	// Show Student
	@GetMapping("/student/{id}")
	public String showStudent(@PathVariable("id") Long id, Model model) {
		model.addAttribute("student", studentServ.getOne(id));
		
		return "showStudent.jsp";
	}
	
	// Create Dorm Page
	@GetMapping("/dorm/new")
	public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
		return "newDorm.jsp";
	}
	
	// Create Dorm Processing
	@PostMapping("/dorm/create")
	public String createDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
		if (result.hasErrors()) {
			return "newDorm.jsp";
		}
		
		
		dormServ.createOne(dorm);
		return "redirect:/";
	}
	
	// Create Student Page
	@GetMapping("/student/new")
	public String newStudent(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("dorms", dormServ.getAll());
		return "newStudent.jsp";
	}
	
	// Create Student Processing
	@PostMapping("/student/create")
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("dorms", dormServ.getAll());
			return "newStudent.jsp";
		}
		
		studentServ.createOne(student);
		return "redirect:/";
	}
	
	// Edit Dorm Page
	@GetMapping("/dorm/editPage/{id}")
	public String editDorm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dorm", dormServ.getOne(id));
		
		return "editDorm.jsp";
	}
	
	// Edit Dorm Processing
	@PutMapping("/dorm/update/{id}")
	public String updateDorm(@PathVariable("id") Long id, @Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
		if (result.hasErrors()) {
			return "editDorm.jsp";
		}
		
		dormServ.updateOne(dorm);
		return "redirect:/dorm/{id}";
	}
	
	
	// Edit Student Page
	@GetMapping("/student/editPage/{id}")
	public String editStudent(@PathVariable("id") Long id, Model model) {
		model.addAttribute("student", studentServ.getOne(id));
		model.addAttribute("dorms", dormServ.getAll());
		return "editStudent.jsp";
	}
	
	// Edit Student Processing
	@PutMapping("/student/update/{id}")
	public String updateStudent(@PathVariable("id") Long id, @Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("dorms", dormServ.getAll());
			return "editStudent.jsp";
		}
		
		studentServ.updateOne(student);
		return "redirect:/student/{id}";
	}
	
	// Delete Dorm
	@GetMapping("/dorm/delete/{id}")
	public String deleteDorm(@PathVariable("id") Long id) {
		dormServ.deleteOne(id);
		return "redirect:/";
	}
	
	// Delete Student
	@GetMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		Student student = studentServ.getOne(id);
		Long dormId = student.getDorm().getId();
		studentServ.deleteOne(id);
		return "redirect:/dorm/" + dormId;
	}
	
	
	// User M2M Serf Process
	@PostMapping("/student/add/{id}")
	public String addStudent(@PathVariable("id") Long id, @RequestParam("id") Long studentId) {
		Dorm dorm = dormServ.getOne(id);



		Student student = studentServ.getOne(studentId);

		dormServ.addExtra(dorm, student);
		
		return "redirect:/dorm/{id}";
	}
	
	
	// User M2M Serf Process undo
	@GetMapping("/student/remove/{id}")
	public String removeStudent(@PathVariable("id") Long id) {
		Student student = studentServ.getOne(id);
		Dorm dorm = student.getDorm();
		System.out.println(dorm);
		Long dormId = student.getDorm().getId();
		dormServ.removeExtra(dorm, student);
		
		return "redirect:/dorm/" + dormId;
	}
	
	

}
