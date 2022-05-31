package com.project.cotafacil.exception.client;

public class ClientAlreadyExistingException extends Exception {

	private static final long serialVersionUID = -7848662610303179161L;

	public ClientAlreadyExistingException(){
		super();
	}
	
	public ClientAlreadyExistingException(String msg){
		super(msg);
	}
	
	public ClientAlreadyExistingException(String msg, Throwable cause){
		super(msg, cause);
	}
}
