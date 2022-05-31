package com.project.cotafacil.exception.provider;

public class ProviderAlreadyExistingException extends Exception {

	private static final long serialVersionUID = -7848662610303179161L;

	public ProviderAlreadyExistingException(){
		super();
	}
	
	public ProviderAlreadyExistingException(String msg){
		super(msg);
	}
	
	public ProviderAlreadyExistingException(String msg, Throwable cause){
		super(msg, cause);
	}
}
