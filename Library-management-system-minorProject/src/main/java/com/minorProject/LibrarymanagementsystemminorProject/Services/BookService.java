package com.minorProject.LibrarymanagementsystemminorProject.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minorProject.LibrarymanagementsystemminorProject.Models.Author;
import com.minorProject.LibrarymanagementsystemminorProject.Models.Book;
import com.minorProject.LibrarymanagementsystemminorProject.Requests.BookCreateRequest;
import com.minorProject.LibrarymanagementsystemminorProject.dao.AuthorRepo;
import com.minorProject.LibrarymanagementsystemminorProject.dao.BoookRepo;

import jakarta.validation.Valid;

@Service
public class BookService {
	
	@Autowired
	BoookRepo bookrepo;
	
	@Autowired
	AuthorService authorService;

	public void createBook(@Valid Book book) {
		// TODO Auto-generated method stub
		//logic for book
		//want to add author also
		
		Author author =  authorService.createOrGetAuthor(book.getAuthor());
		book.setAuthor(author);
		bookrepo.save(book);
		
	}

	
	public void getBookById(int bookId) {
		// TODO Auto-generated method stub
		
	}


	public List<Book> getAllBooks() {
		List<Book> books = bookrepo.findAll();
		return books;
		// TODO Auto-generated method stub
		
	}


	
}
