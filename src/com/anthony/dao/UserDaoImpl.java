package com.anthony.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.anthony.datasource.C3P0Utils;
import com.anthony.domain.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User findUserByEmail(String email) throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
		User user = qr.query("select * from users where email=?", new BeanHandler<User>(User.class),email);
		return user;
	}

}
