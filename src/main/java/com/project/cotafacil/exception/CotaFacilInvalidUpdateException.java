package com.project.cotafacil.exception;

public class CotaFacilInvalidUpdateException extends Exception {
	
	private static final long serialVersionUID = 2592422002190213624L;

	public CotaFacilInvalidUpdateException(){
		super();
	}
	
	public CotaFacilInvalidUpdateException(String msg){
		super(msg);
	}
	
	public CotaFacilInvalidUpdateException(String msg, Throwable cause){
		super(msg, cause);
	}

}
