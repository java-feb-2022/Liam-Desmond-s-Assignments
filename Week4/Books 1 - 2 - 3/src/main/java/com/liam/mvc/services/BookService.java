package com.liam.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liam.mvc.models.Book;
import com.liam.mvc.repositories.BookRepository;

@Service
public class BookService {
	
//  adding the book repository as a dependency
	
//	private final BookRepository bookRepo;
//	
//	public BookService(BookRepository bookRepo) {
//		this.bookRepo = bookRepo;
//	};
	
	@Autowired
	private BookRepository bookRepo;
	
    // returns all the books
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    
    // creates a book
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }
    
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        }
        else {
            return null;
        }
    }
    
    public Book updateBook(Book updatedbook) {

        return bookRepo.save(updatedbook);
    }

    	

    
    public void deleteBook(Long Id) {
    	Optional<Book> optionalBook = (bookRepo.findById(Id));
    	if(optionalBook.isPresent()) {
        	bookRepo.deleteById(Id);
    	}

    }

}
