package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			l.info("In Method retrieveAllUsers :");
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				l.debug(user.toString());
			} 
			l.info("Out Method retrieveAllUsers :");
		}catch (Exception e) {
			l.error("Error in retrieveAllUsers : "+e);
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		l.info("In Method addUser :");
		User u_saved = userRepository.save(u); 
		l.info("In Method addUser :");
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		l.info("In Method updateUser :");
		User u_saved = userRepository.save(u); 
		l.info("In Method updateUser :");
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		l.info("In Method deleteUser :");
		userRepository.deleteById(Long.parseLong(id)); 
		l.info("In Method deleteUser :");
	}

	@Override
	public User retrieveUser(String id) {
		l.info("In Method retrieveUser :");
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		l.info("In Method retrieveUser :");
		return u; 
	}

}