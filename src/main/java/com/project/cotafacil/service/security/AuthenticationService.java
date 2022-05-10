package com.project.cotafacil.service.security;

import com.project.cotafacil.dto.model.security.JwtUserDTO;
import com.project.cotafacil.dto.model.security.TokenDTO;

public interface AuthenticationService {
	
	TokenDTO authenticate(JwtUserDTO dto); 
	
}
