package com.project.cotafacil.exception;

public class CotaFacilNotFoundException extends Exception {
	
	private static final long serialVersionUID = -2586209354700102349L;
	
	public CotaFacilNotFoundException(){
		super();
	}
	
	public CotaFacilNotFoundException(String msg){
		super(msg);
	}
	
	public CotaFacilNotFoundException(String msg, Throwable cause){
		super(msg, cause);
	}
}
