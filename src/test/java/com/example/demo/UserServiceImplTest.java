package com.example.demo;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;

import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.services.IUserService;

//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplTest {

	@Autowired
	IUserService us;
	  
	@Test
	@Order(1) //c
	public void testRetrieveAllUsers(){
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(us.getUsersCount(), listUsers.size());
	}

	@Test
	@Order(2) //c
	public void testAddUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2013-05-30");
		User u = new User("John","Doe",d,Role.TECHNICIEN);
		User userAdded = us.addUser(u);
		Assertions.assertEquals(u.getLastName(),userAdded.getLastName());
	}
	
	@Test
	@Order(3) //c
	public void testModifyUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2017-06-07");
		User u = new User(2L,"Fahd","Larayedh",d,Role.INGENIEUR);
		User userUpdated = us.updateUser(u);
		Assertions.assertEquals(u.getLastName(),userUpdated.getLastName());
	}
	
	@Test
	@Order(4) //c
	public void testRetrieveUser(){
		User user = us.retrieveUser(2L);
		Assertions.assertEquals(2L, user.getId());
	}
	
	@Test
	@Order(5)  //d
	public void testDeleteUser(){
		Long id = us.getLastAddedUserId();
		us.deleteUser(id); //d
		Assertions.assertNull(us.retrieveUser(id)); //d
	}
	
}
