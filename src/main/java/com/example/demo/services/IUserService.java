package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.User;

public interface IUserService { 
	 
	List<User> retrieveAllUsers(); 
	User addUser(User u);
	void deleteUser(Long id);
	User updateUser(User u);
	User retrieveUser(Long id);
	int getUsersCount();
	Long getLastAddedUserId();
} 
 
