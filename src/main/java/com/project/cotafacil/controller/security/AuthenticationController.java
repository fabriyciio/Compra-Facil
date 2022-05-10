package com.project.cotafacil.controller.security;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cotafacil.dto.model.security.JwtUserDTO;
import com.project.cotafacil.dto.model.security.TokenDTO;
import com.project.cotafacil.model.dto.response.Response;
import com.project.cotafacil.service.security.AuthenticationService;
import com.project.cotafacil.service.user.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping
	@ApiOperation("Rota para fazer autenticação do usuário")
	public ResponseEntity<Response<TokenDTO>> generateTokenJwt(@Valid @RequestBody JwtUserDTO dto, BindingResult result) throws AuthenticationException {
		
		Response<TokenDTO> response = new Response<>();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("crip 123456 "+encoder.encode("123456"));
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		response.setData(authenticationService.authenticate(dto));
		
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
