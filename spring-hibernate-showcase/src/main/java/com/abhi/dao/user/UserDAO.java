package com.abhi.dao.user;

import java.util.List;

import com.abhi.entity.UserDetails;

public interface UserDAO
{
	/**
	 * Add User
	 * @param user
	 */
	public void addUser(UserDetails user);

	/**
	 * Delete User
	 * @param userId
	 */
	public void deleteUser(Integer userId);

	/**
	 * Find by Id..
	 * @return
	 */
	public UserDetails findByUserId(Integer userId);

	/**
	 * Find by Id..
	 * @return
	 */
	public List<UserDetails> findByEmailId(String emailId);
}