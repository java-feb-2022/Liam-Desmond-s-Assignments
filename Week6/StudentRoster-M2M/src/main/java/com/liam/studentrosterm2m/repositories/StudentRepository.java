package com.liam.studentrosterm2m.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.liam.studentrosterm2m.models.Course;
import com.liam.studentrosterm2m.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	
	List<Student> findAll();
	
	List<Student> findByCoursesNotContains(Course course);

}
