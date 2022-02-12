package com.liam.studentrosterm2m.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liam.studentrosterm2m.models.Course;
import com.liam.studentrosterm2m.models.Student;
import com.liam.studentrosterm2m.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;
	
	// Get All
	public List<Student> getAll() {
		return studentRepo.findAll();
	}
	
	// Get One
	public Student getOne(Long id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	// Create
	public Student createOne(Student student) {
		return studentRepo.save(student);
	}
	
	
	// Update
	public Student updateOne(Student student) {
		return studentRepo.save(student);
	}
	
	// Delete
	public void deleteOne(Long id) {
		studentRepo.deleteById(id);
	}
	
	public List<Student> findByCoursesNotContains(Course course) {
		return studentRepo.findByCoursesNotContains(course);
	}

}
