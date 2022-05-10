package com.project.cotafacil.model.security;

import com.project.cotafacil.model.user.User;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtUserFactory {
	
	
	public static JwtUser create(User user) {
		return new JwtUser(user.getId(), user.getMail(), user.getPassword());
	}
	
}
