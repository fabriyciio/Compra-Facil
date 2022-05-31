package com.project.cotafacil.exception.provider;

public class ProviderFoundException extends Exception {
	
	
	private static final long serialVersionUID = 1925990820236846068L;

	public ProviderFoundException(){
		super();
	}
	
	public ProviderFoundException(String msg){
		super(msg);
	}
	
	public ProviderFoundException(String msg, Throwable cause){
		super(msg, cause);
	}
}
