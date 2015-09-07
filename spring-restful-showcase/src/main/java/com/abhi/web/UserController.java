package com.abhi.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import com.abhi.model.User;
import com.abhi.model.Users;

@Controller
@RequestMapping("/users")
public class UserController 
{
	@RequestMapping(
			method = RequestMethod.GET, 
			value="/{id}", 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_XML_VALUE})
	@ResponseBody 
	public ResponseEntity<User> getUserById(@PathVariable String id) 
	{	
		//Create User..
		User user = new User();
		user.setFirstName("Abhi");
		user.setLastName("T");
		user.setId("1");

		//Set the headers..
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(linkTo(UserController.class).slash(user.getId()).toUri());

		return new ResponseEntity<User>(user, headers, HttpStatus.CREATED);
	}

	@RequestMapping(
			method = RequestMethod.GET, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_XML_VALUE})
	@ResponseBody 
	public ResponseEntity<Users> getAllUsers() 
	{
		List<User> userList = new ArrayList<User>();
		User user1 = new User();
		user1.setFirstName("Abhi");
		user1.setLastName("T");
		userList.add(user1);

		User user2 = new User();
		user2.setFirstName("Anu");
		user2.setLastName("T");
		userList.add(user2);

		Users users = new Users();
		users.setUsers(userList);

		//Set the headers..
		HttpHeaders headers = new HttpHeaders();

		return new ResponseEntity<Users>(users,headers, HttpStatus.CREATED);
	}
}
