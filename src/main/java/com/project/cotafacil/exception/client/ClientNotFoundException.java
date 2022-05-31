package com.project.cotafacil.exception.client;

public class ClientNotFoundException extends Exception {

	private static final long serialVersionUID = 1187585893471087728L;

	public ClientNotFoundException(){
		super();
	}
	
	public ClientNotFoundException(String msg){
		super(msg);
	}
	
	public ClientNotFoundException(String msg, Throwable cause){
		super(msg, cause);
	}
}
