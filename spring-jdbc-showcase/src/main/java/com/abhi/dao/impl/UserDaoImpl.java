package com.abhi.dao.impl;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.abhi.dao.UserDao;
import com.abhi.entity.User;
import com.abhi.entity.UserRowMapper;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao 
{
	@Override
	public void insert(User user){
		String sql = "INSERT INTO USER_PROFILE " + "(ID, NAME, AGE) VALUES (USER_ID_SEQ.NEXTVAL, ?, ?)";
		getJdbcTemplate().update(sql, new Object[] {
				user.getName(),user.getAge()  
		});
	}

	@Override
	public User findById(Integer userId) {
		String sql = "SELECT * FROM USER_PROFILE " + "WHERE ID = ?";
		User user = (User)getJdbcTemplate().queryForObject(sql, new Object[] {userId}, new UserRowMapper());
		return user;
	}
}