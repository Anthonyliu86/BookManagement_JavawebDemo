package com.anthony.service;

import com.anthony.domain.User;

public interface UserService {
	
	public User findUserByEmail(String email);

}
