package com.minorProject.LibrarymanagementsystemminorProject.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minorProject.LibrarymanagementsystemminorProject.Models.User;
import com.minorProject.LibrarymanagementsystemminorProject.Requests.BookCreateRequest;
import com.minorProject.LibrarymanagementsystemminorProject.dao.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public void createUser(User user) {
		// TODO Auto-generated method stub
		userRepo.save(user);
		
		
	}

	public List<User> getStudents() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	

	public Optional<User> getUserById(int userId) {
		// TODO Auto-generated method stub
		return userRepo.findById(userId);
	}

}
