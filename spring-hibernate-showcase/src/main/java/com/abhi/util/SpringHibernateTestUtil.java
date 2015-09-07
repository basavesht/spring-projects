package com.abhi.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abhi.entity.UserDetails;
import com.abhi.service.UserManager;

public class SpringHibernateTestUtil {

	public static void main(String[] args) 
	{
		ApplicationContext context = null;
		UserDetails userDetails = new UserDetails();
		try 
		{
			//Initialize spring application context...
			context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

			//Get the UserService instance from bean factory..
			UserManager userManager = (UserManager) context.getBean("userManager");

			//Create a dummy user instance..
			userDetails.setFirstname("Abhi");
			userDetails.setLastname("T");
			userDetails.setEmail("basavesh.t@gmail.com");
			userDetails.setTelephone("9972048321");

			//Create User..
			userManager.addUser(userDetails);

			//Find User by ID..
			userDetails = null;
			userDetails = userManager.findByUserId(1);
			System.out.println("User :" + userDetails.getFirstname());

			//Find User by email id..
			userDetails = null;
			userDetails = userManager.findByUserEmailId("basavesh.t@gmail.com");
			System.out.println("Result :" + ((userDetails!=null) ? userDetails.getFirstname()  : "No Users Found"));
		} 
		catch (BeansException e) {
			e.printStackTrace();
		}
		finally {
			((ClassPathXmlApplicationContext) context).close(); 
		}
	}

}
