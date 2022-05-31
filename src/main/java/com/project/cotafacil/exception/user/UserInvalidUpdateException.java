package com.project.cotafacil.exception.user;

public class UserInvalidUpdateException extends Exception {
	
	private static final long serialVersionUID = 5742484280918634409L;

	public UserInvalidUpdateException(){
		super();
	}
	
	public UserInvalidUpdateException(String msg){
		super(msg);
	}
	
	public UserInvalidUpdateException(String msg, Throwable cause){
		super(msg, cause);
	}
}
