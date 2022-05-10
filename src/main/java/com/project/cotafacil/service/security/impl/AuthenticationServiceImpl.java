package com.project.cotafacil.service.security.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.cotafacil.dto.model.security.JwtUserDTO;
import com.project.cotafacil.dto.model.security.TokenDTO;
import com.project.cotafacil.model.security.JwtUser;
import com.project.cotafacil.model.user.User;
import com.project.cotafacil.service.security.AuthenticationService;
import com.project.cotafacil.service.user.UserService;
import com.project.cotafacil.util.security.JwtTokenUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Override
	public TokenDTO authenticate(JwtUserDTO dto) throws AuthenticationException{
		
		TokenDTO response = new TokenDTO();
		
		Authentication authentication = authenticationManager.authenticate
				(new UsernamePasswordAuthenticationToken(dto.getMail(), dto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getMail());
		String token = jwtTokenUtil.getToken(userDetails);
		
		JwtUser user = (JwtUser) authentication.getPrincipal();
		
		response = new TokenDTO(token,findUser(user).convertEntityToDTO());
		
		return response;
	}
	
	private User findUser(JwtUser jwtUser) throws UsernameNotFoundException {
		
		Optional<User> user = userService.findById(jwtUser.getId());
		
		if(!user.isPresent()) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		
		return user.get();
	}
}
