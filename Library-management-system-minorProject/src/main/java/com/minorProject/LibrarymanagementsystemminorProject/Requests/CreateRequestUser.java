package com.minorProject.LibrarymanagementsystemminorProject.Requests;

import com.minorProject.LibrarymanagementsystemminorProject.Models.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class CreateRequestUser {
	private String name;

	private String phNum;

	@NotBlank
	@Email
	private String email;
	
	
	public User to() {
		return User.builder().name(name).ph(phNum).email(email).build();
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhNum() {
		return phNum;
	}


	public void setPhNum(String phNum) {
		this.phNum = phNum;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
}
