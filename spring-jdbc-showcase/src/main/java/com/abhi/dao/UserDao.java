package com.abhi.dao;

import com.abhi.entity.User;

public interface UserDao {
	public void insert(User user);
	public User findById(Integer userId);
}
