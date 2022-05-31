package com.project.cotafacil.exception.admin;

public class UserMailFoundException extends Exception {
	
	private static final long serialVersionUID = -8810237107364618098L;

	public UserMailFoundException(){
		super();
	}
	
	public UserMailFoundException(String msg){
		super(msg);
	}
	
	public UserMailFoundException(String msg, Throwable cause){
		super(msg, cause);
	}
}
