package com.project.cotafacil.exception.admin;

public class CategoryInvalidUpdateException extends Exception {
	
	private static final long serialVersionUID = 5742484280918634409L;

	public CategoryInvalidUpdateException(){
		super();
	}
	
	public CategoryInvalidUpdateException(String msg){
		super(msg);
	}
	
	public CategoryInvalidUpdateException(String msg, Throwable cause){
		super(msg, cause);
	}
}
