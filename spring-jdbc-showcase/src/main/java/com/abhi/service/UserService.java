package com.abhi.service;

import com.abhi.entity.User;

public interface UserService {
	public boolean createUser(User user);
	public User findUser(Integer id);
}
