package com.abhi.service;

import com.abhi.entity.UserDetails;

public interface UserManager
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
	public UserDetails findByUserEmailId(String emailId);
}
