package com.minorProject.LibrarymanagementsystemminorProject.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.minorProject.LibrarymanagementsystemminorProject.Models.User;
import com.minorProject.LibrarymanagementsystemminorProject.Requests.CreateRequestUser;
import com.minorProject.LibrarymanagementsystemminorProject.Services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public void createStudent(@Valid @RequestBody CreateRequestUser createRequestUser) {
		userService.createUser(createRequestUser.to());
	}
	
	@GetMapping("/user/all")
	public List<User> getUser() {
	return	userService.getStudents();
	}
	
	@GetMapping("/user/{userId}")
	public User getUserById(@PathVariable("userId") int userId ) {
		return userService.getUserById(userId);
	}
	

}
