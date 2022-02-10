package com.liam.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liam.bookclub.models.Book;

import com.liam.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
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
			
			
			


}
