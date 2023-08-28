package com.minorProject.LibrarymanagementsystemminorProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minorProject.LibrarymanagementsystemminorProject.Models.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

}
