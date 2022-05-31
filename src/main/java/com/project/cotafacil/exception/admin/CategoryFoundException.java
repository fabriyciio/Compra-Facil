package com.project.cotafacil.exception.admin;

public class CategoryFoundException extends Exception {
	
	
	private static final long serialVersionUID = 1925990820236846068L;

	public CategoryFoundException(){
		super();
	}
	
	public CategoryFoundException(String msg){
		super(msg);
	}
	
	public CategoryFoundException(String msg, Throwable cause){
		super(msg, cause);
	}
}
