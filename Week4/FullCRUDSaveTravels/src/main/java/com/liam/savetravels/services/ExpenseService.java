package com.liam.savetravels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liam.savetravels.models.Expense;
import com.liam.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepo;
	
	
	// Get All
	public List<Expense> getAll() {
		return expenseRepo.findAll();
	}
	
	// Get One
	public Expense getOne(Long id) {
		return expenseRepo.findById(id).orElse(null);
	}
	
	// Create
	public Expense createOne(Expense car) {
		return expenseRepo.save(car);
	}
	
	
	// Update
	public Expense updateOne(Expense car) {
		return expenseRepo.save(car);
	}
	
	// Delete
	public void deleteOne(Long id) {
		expenseRepo.deleteById(id);
	}

}
