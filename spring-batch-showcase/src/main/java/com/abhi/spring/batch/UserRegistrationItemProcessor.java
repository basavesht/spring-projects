package com.abhi.spring.batch;

import org.springframework.batch.item.ItemProcessor;

import com.abhi.entity.UserDetails;

public class UserRegistrationItemProcessor implements ItemProcessor<UserDetails, UserDetails> {

	@Override
	public UserDetails process(UserDetails user) throws Exception {
		System.out.println("Into the Item Processor");
		return user;
	}
}
