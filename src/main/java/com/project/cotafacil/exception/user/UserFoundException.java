package com.project.cotafacil.exception.user;

public class UserFoundException extends Exception {
	
	
	private static final long serialVersionUID = 1925990820236846068L;

	public UserFoundException(){
		super();
	}
	
	public UserFoundException(String msg){
		super(msg);
	}
	
	public UserFoundException(String msg, Throwable cause){
		super(msg, cause);
	}
}
