package com.liam.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.liam.mvc.models.Book;
import com.liam.mvc.services.BookService;

@Controller
public class BooksController {
	
	@Autowired
	private BookService bookServ;
	
	// Get All
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookServ.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }
    
    // Get One
    @RequestMapping("/books/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Book book = bookServ.findBook(id);
        model.addAttribute("book", book);
        return "/books/show.jsp";
    }
    
    // Create Form
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }

    // Create Processing
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
    	
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookServ.createBook(book);
            return "redirect:/books";
        }
    }
    
    // Edit Form
    @RequestMapping("/books/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Book book = bookServ.findBook(id);
        model.addAttribute("book", book);
        return "/books/edit.jsp";
    }
    
    // Edit Processing
    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            bookServ.updateBook(book);
            return "redirect:/books";
        }
    }
    
    
    // Delete
    @RequestMapping(value="/books/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bookServ.deleteBook(id);
        return "redirect:/books";
    }
    
    
}
