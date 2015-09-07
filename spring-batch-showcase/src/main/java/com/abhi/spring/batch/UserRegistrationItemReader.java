package com.abhi.spring.batch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.abhi.entity.UserDetails;
import com.abhi.service.UserManager;

public class UserRegistrationItemReader implements ItemReader<UserDetails> {

	@Autowired
	private UserManager userManagerService;

	private Collection<UserDetails> userList = null;
	private Iterator<UserDetails> userListIterator = null;

	@Override
	/**
	 * All the read items will be aggregated and then passed to the ItemWriter.
	 */
	public UserDetails read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException 
	{
		System.out.println("Into the Item Reader");

		//Create a list of users..
		if(userList == null) {
			userList = new ArrayList<UserDetails>();
			UserDetails userDtls = userManagerService.findByUserId(1);
			if(userDtls!=null && userDtls.getId()!=null) {
				userList.add(userDtls);
			}
			userListIterator = userList.iterator();
		}

		//Return each user one after the other..
		if (userList!=null && userList.size() >= 1) {
			if(userListIterator.hasNext()){
				return (UserDetails) userListIterator.next();
			}
		}
		return null;
	}
}
