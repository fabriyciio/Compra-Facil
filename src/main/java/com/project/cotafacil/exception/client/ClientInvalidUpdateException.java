package com.project.cotafacil.exception.client;

public class ClientInvalidUpdateException extends Exception {
	
	public ClientInvalidUpdateException(){
		super();
	}
	
	public ClientInvalidUpdateException(String msg){
		super(msg);
	}
	
	public ClientInvalidUpdateException(String msg, Throwable cause){
		super(msg, cause);
	}
}
