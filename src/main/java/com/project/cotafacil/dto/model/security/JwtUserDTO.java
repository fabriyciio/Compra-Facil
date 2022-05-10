package com.project.cotafacil.dto.model.security;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtUserDTO {
	
	@NotNull(message = "Preencher o email")
	@NotEmpty(message = "Preencher o email")
	private String mail;
	
	@NotNull(message = "Preencher a senha")
	@NotEmpty(message = "Preencher a senha")
	private String password;

}
