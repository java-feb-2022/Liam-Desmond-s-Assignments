package com.liam.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.liam.studentroster.models.Student;
import com.liam.studentroster.repositories.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepository studentRepo;
	
	// Get All
	public List<Student> getAll() {
		return studentRepo.findAll();
	}
	
	public Student getOne(Long id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	public Student createOne(Student student) {
		return studentRepo.save(student);
	}
	
	public Student updateOne(Student student) {
		return studentRepo.save(student);
	}
	
	public void deleteOne(Long id) {
		studentRepo.deleteById(id);
	}
}
