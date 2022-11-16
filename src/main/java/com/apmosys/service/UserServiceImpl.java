package com.apmosys.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apmosys.helper.UserFoundException;
import com.apmosys.model.User;
import com.apmosys.model.UserRole;
import com.apmosys.repository.RoleRepository;
import com.apmosys.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//user registration
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local =this.userRepository.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.println("User is already registred");
			throw new UserFoundException("User already prsent");
		}
		else {
			//user create 
			for(UserRole ur: userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local=this.userRepository.save(user);
		}
		return local;
	}

	@Override
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
	}

	public List<User> getAllUser() {
		return this.userRepository.findAll();
	}

}
