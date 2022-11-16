package com.apmosys.helper;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException() {
	   super("User with this username already there in DB!! try with another username.");
	}
	
	public UserNotFoundException(String msg)
	{
		super(msg);
	}

}
