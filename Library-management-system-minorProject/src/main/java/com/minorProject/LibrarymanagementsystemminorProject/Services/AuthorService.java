package com.minorProject.LibrarymanagementsystemminorProject.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.minorProject.LibrarymanagementsystemminorProject.Models.Author;
import com.minorProject.LibrarymanagementsystemminorProject.dao.AuthorRepo;

public class AuthorService {
	// author will exist or it will not
	// if it do not exist we have to create an author
	//if author exist then will have to use the same author
	
	@Autowired
	AuthorRepo authorRepo;
	public Author createOrGetAuthor(Author author) {
		Author authorFromDb = authorRepo.findAuthor(author.getEmail());
		if(authorFromDb==null) {
			authorFromDb= authorRepo.save(author);
		}
		return authorFromDb;
	}
}
