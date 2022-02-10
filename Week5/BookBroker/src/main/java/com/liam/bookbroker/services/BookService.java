package com.liam.bookbroker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liam.bookbroker.models.Book;
import com.liam.bookbroker.models.User;
import com.liam.bookbroker.repositories.BookRepository;
import com.liam.bookbroker.repositories.UserRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	// Get All
	public List<Book> getAll() {
		return bookRepo.findAll();
	}
	
	// Get One
	public Book getOne(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
	
	// Create
	public Book createOne(Book book) {
		return bookRepo.save(book);
	}
	
	
	// Update
	public Book updateOne(Book book) {
		return bookRepo.save(book);
	}
	
	// Delete
	public void deleteOne(Long id) {
		bookRepo.deleteById(id);
	}
	
	
	// Add -thing-
	public void addExtra(User user, Book book) {
		

		List<Book> books = user.getBorrowed();
		
		books.add(book);
		book.setBorrower(user);
		bookRepo.save(book);
		userRepo.save(user);
	}
	
	// Remove -thing-
	public void removeExtra(User user, Book book) {
		

		List<Book> books = user.getBorrowed();
		
		books.remove(book);
		book.setBorrower(null);
		bookRepo.save(book);
		userRepo.save(user);
	}
	

}
