package com.minorProject.LibrarymanagementsystemminorProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minorProject.LibrarymanagementsystemminorProject.Models.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer> {

	Author findAuthor(String email);

	

}
