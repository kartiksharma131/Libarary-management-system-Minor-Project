package com.minorProject.LibrarymanagementsystemminorProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minorProject.LibrarymanagementsystemminorProject.Models.Book;
import com.minorProject.LibrarymanagementsystemminorProject.Models.Transaction;
import com.minorProject.LibrarymanagementsystemminorProject.Models.TransactionType;
import com.minorProject.LibrarymanagementsystemminorProject.Models.User;

public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

	//i want to find the book and student with transaction type - issue it schould desc wrt id
	List<Transaction> findByBookAndUserAndTransactionTypeOrderByIdDesc(Book book,User user,TransactionType transactionType);
	Transaction sindTop1ByBookAndUserAndTransactionTypeOrderByDesc(Book book, User user,TransactionType transactionType);
}

