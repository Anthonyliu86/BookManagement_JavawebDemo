package com.anthony.service;

import java.sql.SQLException;

import com.anthony.dao.UserDao;
import com.anthony.dao.UserDaoImpl;
import com.anthony.domain.User;

public class UserServiceImpl implements UserService {
	
	// ����һ��Dao�����
	UserDao ud = new UserDaoImpl();

	@Override
	public User findUserByEmail(String email) {
		try {
			return ud.findUserByEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
