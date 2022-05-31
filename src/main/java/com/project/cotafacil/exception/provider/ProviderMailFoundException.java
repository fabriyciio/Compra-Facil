package com.project.cotafacil.exception.provider;

public class ProviderMailFoundException extends Exception {
	
	private static final long serialVersionUID = -8810237107364618098L;

	public ProviderMailFoundException(){
		super();
	}
	
	public ProviderMailFoundException(String msg){
		super(msg);
	}
	
	public ProviderMailFoundException(String msg, Throwable cause){
		super(msg, cause);
	}
}
