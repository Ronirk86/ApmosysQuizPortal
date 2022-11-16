package com.apmosys.service;

import java.util.Set;

import com.apmosys.model.User;
import com.apmosys.model.UserRole;

public interface IUserService {

	//create user
	public User createUser(User user,Set<UserRole> userRoles) throws Exception;
    
	//get user
	public User getUser(String username);
	
	//delete user by id
	public void deleteUser(Long userId);
}

