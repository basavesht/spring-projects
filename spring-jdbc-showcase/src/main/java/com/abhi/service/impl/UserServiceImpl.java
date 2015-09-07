package com.abhi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.dao.UserDao;
import com.abhi.entity.User;
import com.abhi.service.UserService;

@Service ("userService")
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;

	@Override
	public boolean createUser(User user) {
		try {
			userDao.insert(user);
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public User findUser(Integer id) {
		User user = null;
		try {
			user = userDao.findById(id);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
