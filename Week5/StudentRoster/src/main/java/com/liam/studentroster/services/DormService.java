package com.liam.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liam.studentroster.models.Dorm;
import com.liam.studentroster.models.Student;
import com.liam.studentroster.repositories.DormRepository;
import com.liam.studentroster.repositories.StudentRepository;

@Service
public class DormService {
	
	@Autowired
	private DormRepository dormRepo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	
	// Get All
	public List<Dorm> getAll() {
		return dormRepo.findAll();
	}
	
	public Dorm getOne(Long id) {
		return dormRepo.findById(id).orElse(null);
	}
	
	public Dorm createOne(Dorm dorm) {
		return dormRepo.save(dorm);
	}
	
	public Dorm updateOne(Dorm dorm) {
		return dormRepo.save(dorm);
	}
	
	public void deleteOne(Long id) {
		dormRepo.deleteById(id);
	}
	
	// Add -thing-
	public void addExtra(Dorm dorm, Student student) {
		

		List<Student> students = dorm.getStudents();
		
		students.add(student);
		student.setDorm(dorm);
		studentRepo.save(student);
		dormRepo.save(dorm);
	}
	
	// Remove -thing-
	public void removeExtra(Dorm dorm, Student student) {
		

		List<Student> students = dorm.getStudents();
		
		students.remove(student);
		student.setDorm(null);
		studentRepo.save(student);
		dormRepo.save(dorm);
	}
	
	
}
