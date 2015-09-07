package com.abhi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abhi.dao.user.UserDAO;
import com.abhi.entity.UserDetails;
import com.abhi.service.UserManager;

@Service(value = "userManager")
public class UserManagerImpl implements UserManager
{
	@Autowired
	private UserDAO userDao;

	@Override
	@Transactional
	public void addUser(UserDetails user) {
		userDao.addUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(Integer userId) {
		userDao.deleteUser(userId);
	}

	@Override
	@Transactional
	@Cacheable(value = "users", key = "#userId") // Value attribute should match with the cache instance defined in cache-config.xml
	public UserDetails findByUserId(Integer userId) {
		return userDao.findByUserId(userId);
	}

	@Override
	@Transactional
	@Cacheable(value = "users", condition = "#emailId == 'basavesh.t@gmail.com'")
	public UserDetails findByUserEmailId(String emailId) {
		List<UserDetails> users = userDao.findByEmailId(emailId);
		if(users!=null && !users.isEmpty()) {
			return userDao.findByEmailId(emailId).get(0);
		}
		else {
			return null;
		}
	}

	public void setUserDAO(UserDAO userDao) {
		this.userDao = userDao;
	}
}