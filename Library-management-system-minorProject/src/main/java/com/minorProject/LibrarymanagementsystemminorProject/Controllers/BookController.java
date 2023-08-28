package com.minorProject.LibrarymanagementsystemminorProject.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.minorProject.LibrarymanagementsystemminorProject.Models.Book;
import com.minorProject.LibrarymanagementsystemminorProject.Requests.BookCreateRequest;
import com.minorProject.LibrarymanagementsystemminorProject.Services.BookService;

import jakarta.validation.Valid;

@RestController
public class BookController {
	
	/*
	 * Add book
	 * get book by id
	 * get all books
	 * 
	 */
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/book/create")
	public void createBook(@Valid@RequestBody BookCreateRequest bookCreateRequest) {
		bookService.createBook(bookCreateRequest.to());
	}
	
	@GetMapping("/book/getBookById/{bookId}")
	public Optional<Book> getBookById(@PathVariable("bookId") int bookId) {
		return bookService.getBookById(bookId);
		
	}
	
	@GetMapping("book/get/all")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
		
	}
}
