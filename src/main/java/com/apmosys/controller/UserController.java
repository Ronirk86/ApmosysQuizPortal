package com.apmosys.controller;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apmosys.helper.UserFoundException;
import com.apmosys.model.Role;
import com.apmosys.model.User;
import com.apmosys.model.UserRole;
import com.apmosys.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;

	@PostMapping("/register")
	public User createUser(@RequestBody User user) throws Exception {
		
		Set<UserRole> roles=new HashSet<>();
		
		Role role =new Role();
		role.setRoleId(12L);
		role.setRoleName("NORMAL");
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		
		return this.userService.createUser(user, roles);
	}
	
	//get user
	@GetMapping("/getUser/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userService.getUser(username);
	}
	
	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		List<User> u=this.userService.getAllUser();
		List<User> filterUser=new ArrayList<User>();
		for(User us:u) {
			Collection<GrantedAuthority> f=(Collection<GrantedAuthority>) us.getAuthorities();
		    for(GrantedAuthority fs:f) {
		    	if(fs.getAuthority().equals("NORMAL"))
		    		filterUser.add(us);
		    }
		}
		//return this.userService.getAllUser();
		return filterUser;
	}
	
	//delete user by id
	@DeleteMapping("/delete/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		this.userService.deleteUser(userId);
	}
	
	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<?> exceptionHandler(UserFoundException ex){
		return ResponseEntity.ok(ex);
	}
	
}
