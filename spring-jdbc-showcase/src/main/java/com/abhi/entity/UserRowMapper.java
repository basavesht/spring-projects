package com.abhi.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		if (rs!=null) {
			user.setId(rs.getInt("ID"));
			user.setName(rs.getString("NAME"));
			user.setAge(rs.getInt("AGE"));
		}
		return user;
	}
}
