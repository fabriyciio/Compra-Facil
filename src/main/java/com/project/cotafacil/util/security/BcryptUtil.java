package com.project.cotafacil.util.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BcryptUtil {
	
	private BcryptUtil() {}
	
	public static String encode(String password) throws NoSuchAlgorithmException,
	  UnsupportedEncodingException {
		
		 MessageDigest algorithm = MessageDigest.getInstance("SHA-512");
	     byte messageDigestSenhaAdmin[] = algorithm.digest(password.getBytes("UTF-8"));

	     StringBuilder passwordHex = new StringBuilder();
	     for (byte b : messageDigestSenhaAdmin) {
	    	 passwordHex.append(String.format("%02X", 0xFF & b));
	     }
	     return passwordHex.toString();
	   
	}

}
