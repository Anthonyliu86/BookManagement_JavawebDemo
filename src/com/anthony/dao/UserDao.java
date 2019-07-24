package com.anthony.dao;

import java.sql.SQLException;

import com.anthony.domain.User;

public interface UserDao {
	/**
	 * 根据email查找用户
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	public User findUserByEmail(String email) throws SQLException;

}

