package com.minorProject.LibrarymanagementsystemminorProject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minorProject.LibrarymanagementsystemminorProject.Services.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/transaction/issue")
	public String issueBook(@RequestParam("userId")int userId,@RequestParam("bookId") int bookId) throws Exception {
		return transactionService.issueBook(userId,bookId);
	}
	
	@PostMapping("/transaction/return")
	public void returnBook(@RequestParam("studentId")int userId,@RequestParam("bookId")int bookId) throws Exception {
		transactionService.returnBook(userId,bookId);
	}
}
