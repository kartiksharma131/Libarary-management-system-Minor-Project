package com.minorProject.LibrarymanagementsystemminorProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minorProject.LibrarymanagementsystemminorProject.Models.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
