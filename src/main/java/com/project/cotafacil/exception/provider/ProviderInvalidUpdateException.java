package com.project.cotafacil.exception.provider;

public class ProviderInvalidUpdateException extends Exception {
	
	private static final long serialVersionUID = 5742484280918634409L;

	public ProviderInvalidUpdateException(){
		super();
	}
	
	public ProviderInvalidUpdateException(String msg){
		super(msg);
	}
	
	public ProviderInvalidUpdateException(String msg, Throwable cause){
		super(msg, cause);
	}
}
