package com.abhi.spring.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;

import com.abhi.entity.UserDetails;
import com.abhi.service.UserManager;

public class RetryableUserRegistrationWriter implements ItemWriter<UserDetails>
{
	@Autowired
	private UserManager userManagerService;

	@Autowired
	private RetryTemplate retryTemplate;

	@Override
	/**
	 * takes aggregated input from the reader and 'writes' them using a custom
	 * implementation.
	 */
	public void write(List<? extends UserDetails> items) throws Exception {

		System.out.println("Into the Item Writer" + items.size());

		for (final UserDetails user : items) 
		{
			retryTemplate.execute(
					new RetryCallback<Object>() {
						public Object doWithRetry(RetryContext context) throws Exception {
							UserDetails userData =  new UserDetails();
							userData.setFirstname(user.getFirstname() + "1");
							userData.setLastname(user.getLastname() + "1");
							userData.setEmail(user.getEmail() + "1");
							userData.setTelephone("9972048321");                        
							userManagerService.addUser(userData);
							return null;
						}
					}
					);
		}
	}

}
