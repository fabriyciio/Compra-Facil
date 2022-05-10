package com.project.cotafacil.dto.model.security;

import com.project.cotafacil.model.dto.user.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO {
	
	@Getter
	private String token;
	
	@Getter
	private UserDTO user;

}
