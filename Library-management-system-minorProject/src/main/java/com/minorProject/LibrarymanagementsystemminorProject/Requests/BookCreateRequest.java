package com.minorProject.LibrarymanagementsystemminorProject.Requests;

import com.minorProject.LibrarymanagementsystemminorProject.Models.Author;
import com.minorProject.LibrarymanagementsystemminorProject.Models.Book;
import com.minorProject.LibrarymanagementsystemminorProject.Models.Genre;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookCreateRequest {
	@NotBlank
	private String name;
	private int cost;
	@NotNull
	private Genre genre;
	private String authorName;
	@Email
	private String email;
	
	public Book to() {
		
		Author author = Author.builder().name(authorName).email(email).build();
		return Book.builder().name(name).genre(genre).author(author).build();
	}
}
