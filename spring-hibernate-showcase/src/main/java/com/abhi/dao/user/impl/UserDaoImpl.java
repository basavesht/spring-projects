package com.abhi.dao.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.abhi.dao.user.UserDAO;
import com.abhi.entity.UserDetails;

@Repository
public class UserDaoImpl extends GenericDaoImpl<Integer, UserDetails> implements UserDAO
{
	@Override
	public void addUser(UserDetails employee) {
		persist(employee);
	}

	@Override
	public void deleteUser(Integer userId) {
		UserDetails user = (UserDetails) findById(userId);
		if (null != user) {
			remove(user);
		}
	}

	@Override
	public UserDetails findByUserId(Integer userId) {
		return (UserDetails) findById(userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserDetails> findByEmailId(String emailId) {
		Map<String,String> queryParams = new HashMap<String, String>();
		queryParams.put("emailId", emailId);
		return (List<UserDetails>) findByNamedQueryAndNamedParams("UserDetails.findUserByEmailId", queryParams);
	}
}