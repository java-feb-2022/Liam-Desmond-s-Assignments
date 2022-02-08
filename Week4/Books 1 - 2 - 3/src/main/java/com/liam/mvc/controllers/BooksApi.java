package com.liam.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liam.mvc.models.Book;
import com.liam.mvc.services.BookService;

@RestController
public class BooksApi {
	
//	private final BookService bookServ;
//
//	public BooksApi(BookService bookServ) {
//		super();
//		this.bookServ = bookServ;
//	}
	
	@Autowired
	private BookService bookServ;
	
	@RequestMapping("/api/books")
    public List<Book> index() {
        return bookServ.allBooks();
    }
    
    @RequestMapping(value="/api/books", method=RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="numOfPages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookServ.createBook(book);
    }
    
    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookServ.findBook(id);
        return book;
    }
    
//    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
//    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="numOfPages") Integer numOfPages) {
//        Book book = bookServ.updateBook(id, title, desc, lang, numOfPages);
//        return book;
//    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
    	bookServ.deleteBook(id);
    }

}
