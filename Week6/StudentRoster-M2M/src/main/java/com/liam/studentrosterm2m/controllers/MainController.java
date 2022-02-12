package com.liam.studentrosterm2m.controllers;




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

import com.liam.studentrosterm2m.models.Course;
import com.liam.studentrosterm2m.models.Student;
import com.liam.studentrosterm2m.services.CourseService;
import com.liam.studentrosterm2m.services.StudentService;

@Controller
public class MainController {
	
	@Autowired
	private CourseService courseServ;
	
	
	@Autowired
	private StudentService studentServ;
	
	// Dashboard
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("courses", courseServ.getAll());
		return "index.jsp";
	}
	
	// Show Course
	@GetMapping("/course/{id}")
	public String showCourse(@PathVariable("id") Long id, Model model) {
//		model.addAttribute("students", studentServ.getAll());
		model.addAttribute("students", studentServ.findByCoursesNotContains(courseServ.getOne(id)));
		model.addAttribute("course", courseServ.getOne(id));
		
		return "showDorm.jsp";
	}
	
	// Show Student
	@GetMapping("/student/{id}")
	public String showStudent(@PathVariable("id") Long id, Model model) {
//		model.addAttribute("courses", courseServ.getAll());
		model.addAttribute("courses", courseServ.findByStudentsNotContains(studentServ.getOne(id)));
		model.addAttribute("student", studentServ.getOne(id));
		
		return "showStudent.jsp";
	}
	
	// Create Course Page
	@GetMapping("/course/new")
	public String newCourse(@ModelAttribute("course") Course course) {
		return "newCourse.jsp";
	}
	
	// Create Course Processing
	@PostMapping("/course/create")
	public String createCourse(@Valid @ModelAttribute("course") Course course, BindingResult result) {
		if (result.hasErrors()) {
			return "newCourse.jsp";
		}
		
		
		courseServ.createOne(course);
		return "redirect:/";
	}
	
	// Create Student Page
	@GetMapping("/student/new")
	public String newStudent(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("courses", courseServ.getAll());
		return "newStudent.jsp";
	}
	
	// Create Student Processing
	@PostMapping("/student/create")
	public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("courses", courseServ.getAll());
			return "newStudent.jsp";
		}
		
		studentServ.createOne(student);
		return "redirect:/";
	}
	
	// Edit Course Page
	@GetMapping("/course/editPage/{id}")
	public String editCourse(@PathVariable("id") Long id, Model model) {
		model.addAttribute("course", courseServ.getOne(id));
		
		return "editCourse.jsp";
	}
	
	// Edit Course Processing
	@PutMapping("/course/update/{id}")
	public String updateCourse(@PathVariable("id") Long id, @Valid @ModelAttribute("course") Course course, BindingResult result) {
		if (result.hasErrors()) {
			return "editCourse.jsp";
		}
		
		courseServ.updateOne(course);
		return "redirect:/course/{id}";
	}
	
	
	// Edit Student Page
	@GetMapping("/student/editPage/{id}")
	public String editStudent(@PathVariable("id") Long id, Model model) {
		model.addAttribute("student", studentServ.getOne(id));
		model.addAttribute("courses", courseServ.getAll());
		return "editStudent.jsp";
	}
	
	// Edit Student Processing
	@PutMapping("/student/update/{id}")
	public String updateStudent(@PathVariable("id") Long id, @Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("courses", courseServ.getAll());
			return "editStudent.jsp";
		}
		
		studentServ.updateOne(student);
		return "redirect:/student/{id}";
	}
	
	// Delete Course
	@GetMapping("/course/delete/{id}")
	public String deleteCourse(@PathVariable("id") Long id) {
		courseServ.deleteOne(id);
		return "redirect:/";
	}
	
	// Delete Course from show Student - CAREFUL WITH MANY @ MANY
	@PostMapping("/course/delete/{id}")
	public String deleteCourseFromStudentShow(@PathVariable("id") Long id, @RequestParam("student") Course student) {
		Long studentId = student.getId();
				
		courseServ.deleteOne(id);
		return "redirect:/student/" + studentId;
	}
	
	// Delete Student // - CAREFUL WITH MANY @ MANY
	@PostMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id, @RequestParam("course") Course course) {
		Student student = studentServ.getOne(id);
		Long courseId = course.getId();

		studentServ.deleteOne(id);
		return "redirect:/course/" + courseId;
	}
	
	
	
	
	
	// User M2M Serf Process
	@PostMapping("/student/add/{id}")
	public String addStudent(@PathVariable("id") Long id, @RequestParam("id") Long studentId) {
		Course course = courseServ.getOne(id);



		Student student = studentServ.getOne(studentId);

		courseServ.addExtra(student, course);
		
		return "redirect:/course/{id}";
	}
	
	
	// User M2M Serf Process undo
	@PostMapping("/student/remove/{id}")
	public String removeStudent(@PathVariable("id") Long id, @RequestParam("course") Course course) {
		Student student = studentServ.getOne(id);

		Long courseId = course.getId();
		courseServ.removeExtra(student, course);
		
		return "redirect:/course/" + courseId;
	}
	
	
	// User M2M Serf Process
	@PostMapping("/course/add/{id}")
	public String addCourse(@PathVariable("id") Long id, @RequestParam("id") Long courseId) {
		Student student = studentServ.getOne(id);



		Course course = courseServ.getOne(courseId);

		courseServ.addExtra(student, course);
		
		return "redirect:/student/{id}";
	}
	
	
	// User M2M Serf Process undo
	@PostMapping("/course/remove/{id}")
	public String removeCourse(@PathVariable("id") Long id, @RequestParam("student") Student student) {
		Course course = courseServ.getOne(id);

		Long studentId = student.getId();
		courseServ.removeExtra(student, course);
		
		return "redirect:/student/" + studentId;
	}


}
