package com.minorProject.LibrarymanagementsystemminorProject.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.minorProject.LibrarymanagementsystemminorProject.Models.Book;
import com.minorProject.LibrarymanagementsystemminorProject.Models.Transaction;
import com.minorProject.LibrarymanagementsystemminorProject.Models.TransactionStatus;
import com.minorProject.LibrarymanagementsystemminorProject.Models.TransactionType;
import com.minorProject.LibrarymanagementsystemminorProject.Models.User;
import com.minorProject.LibrarymanagementsystemminorProject.dao.TransactionRepo;

@Service
public class TransactionService {

	@Value("${student.book.quota}")
	int studentBookQuota;
	
	@Autowired
	UserService userService;
	
	
	
	@Autowired
	BookService bookService;
	
	@Autowired
	TransactionRepo transactionRepo;
	
	public String issueBook(int userId, int bookId) throws Exception {
		// TODO Auto-generated method stub
		//user present or not
		//book available or not
		//student book limit or quota crossed or not
		//create transaction with initial state as pending
		//transaction type to issue
		//make the book unavailable and assign it to a student 
		// update the txn successful
		
		User user = userService.getUserById(userId);
		if(user==null) {
			throw new Exception("Student is not present, unable to issue book ");
		}
		
		Book book = bookService.getBookById(bookId).orElse(null);
		if(book.getUser()==null) {
			throw new Exception("Book is issued to someone else,unable to issue the book");
		}
		
		if(user.getBookList().size()>=studentBookQuota) {
			throw new Exception("Student quota has reached , unable to issue the book");
		}
		
		Transaction transaction = Transaction.builder()
				.book(book)
				.user(user)
				.TransactionType(TransactionType.ISSUE)
				.TransactionStatus(TransactionStatus.PENDING)
				.transactionId(UUID.randomUUID().toString())
				.build();
		transactionRepo.save(transaction);
		try {
			book.setUser(user);
			bookService.createBook(book);
			transaction.setTransactionStatus(TransactionStatus.SUCCESS);
			transactionRepo.save(transaction);
		}catch(Exception e) {
			book.setUser(null);
			bookService.createBook(book);
			transaction.setTransactionStatus(TransactionStatus.FAILED);
		}
		
		
		return transaction.getTransactionId();
	}

	public void returnBook(int userId, int bookId) throws Exception {
		// TODO Auto-generated method stub
		//check whether the book is assigned to the student or not
		//check for fine and update the transaction
		//we will create the txn with pending status
		//remove the student as assignee
		//make the book available
		//userid should be set to null
		// update the transaction as success
		
		User user = userService.getUserById(userId);
		Book book = bookService.getBookById(bookId).orElse(null);
		if( user ==null || book==null || book.getUser()==null || book.getUser().getUserId()!=userId) {
			throw new Exception("Book or student is either not present or book is not assigned to the student , unable to return");
			
		}
		List<Transaction> issueTxnList  = transactionRepo.findByBookAndUserAndTransactionTypeOrderByIdDesc(book, user, TransactionType.ISSUE);
		Transaction issueTxn= issueTxnList.get(0);
		
		//to check the fine scenario
		
	}

}
