package com.abhi.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abhi.entity.User;
import com.abhi.service.UserService;

public class SpringJDBCTestUtil {

	public static void main(String[] args) 
	{
		ApplicationContext context = null;
		try 
		{
			//Initialize spring application context...
			context = new ClassPathXmlApplicationContext("applicationContext.xml");

			//Get the UserService instance from bean factory..
			UserService userService = (UserService) context.getBean("userService");

			//Create a dummy user instance..
			User user = new User();
			user.setAge(10);
			user.setName("Abhi");

			//Create User..
			boolean isUserCreated = userService.createUser(user);
			System.out.println("User Created :" + isUserCreated);

			//Find User age by name..
			User userDetails = userService.findUser(1);
			System.out.println("User Details :" + userDetails.getAge());
		} 
		catch (BeansException e) {
			e.printStackTrace();
		}
		finally {
			((ClassPathXmlApplicationContext) context).close(); 
		}
	}

}
