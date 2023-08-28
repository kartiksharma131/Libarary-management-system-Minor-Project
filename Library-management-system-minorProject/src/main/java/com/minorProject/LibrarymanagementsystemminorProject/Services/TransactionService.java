package com.minorProject.LibrarymanagementsystemminorProject.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minorProject.LibrarymanagementsystemminorProject.Models.Book;
import com.minorProject.LibrarymanagementsystemminorProject.Models.User;
import com.minorProject.LibrarymanagementsystemminorProject.dao.TransactionRepo;

@Service
public class TransactionService {

	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	TransactionRepo transactionRepo;
	
	public void issueBook(int userId, int bookId) throws Exception {
		// TODO Auto-generated method stub
		//user present or not
		//book available or not
		//student book limit or quota crossed or not
		//create transaction with initial state as pending
		//transaction type to issue
		//make the book unavailable and assign it to a student 
		// update the txn successful
		
		Optional<User> user = userService.getUserById(userId);
		if(user==null) {
			throw new Exception("Student is not present, unable to issue book ");
		}
		
		Book book = bookService.getBookById(bookId).orElse(null);
		if(book.getUser()==null) {
			throw new Exception("Book is issued to someone else,unable to issue the book");
		}
		
	}

	public void returnBook(int userId, int bookId) {
		// TODO Auto-generated method stub
		
	}

}
