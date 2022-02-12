package com.liam.studentrosterm2m.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liam.studentrosterm2m.models.Course;
import com.liam.studentrosterm2m.models.Student;
import com.liam.studentrosterm2m.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepo;
	
	// Get All
	public List<Course> getAll() {
		return courseRepo.findAll();
	}
	
	// Get One
	public Course getOne(Long id) {
		return courseRepo.findById(id).orElse(null);
	}
	
	// Create
	public Course createOne(Course course) {
		return courseRepo.save(course);
	}
	
	
	// Update
	public Course updateOne(Course course) {
		return courseRepo.save(course);
	}
	
	// Delete
	public void deleteOne(Long id) {
		courseRepo.deleteById(id);
	}
	
	// Show all Students that aren't in Dorm
	public List<Course> findByStudentsNotContains(Student student) {
		return courseRepo.findByStudentsNotContains(student);
		
	}
	
	
	
	// Many to Many
	
	// Add -thing-
	public void addExtra(Student student, Course course) {
		
		List<Student> inlist = course.getStudents();
		

		inlist.add(student);

		courseRepo.save(course);
	}
	
	// Remove -thing-
	public void removeExtra(Student student, Course course) {

		List<Student> inlist = course.getStudents();
		

		inlist.remove(student);

		courseRepo.save(course);
	}
}
