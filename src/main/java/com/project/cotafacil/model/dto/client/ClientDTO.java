package com.project.cotafacil.model.dto.client;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import com.project.cotafacil.model.client.*;
import com.project.cotafacil.util.security.BcryptUtil;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
	
	@Getter
	private Long id;
	
	@Getter
	@NotNull(message = "O nome não pode ser nulo.")
	@Length(min=3, max=255, message="O nome deve conter entre 3 e 255 caracteres.")
	private String name;

	@Getter
	@Length(max=255, message="O email deve conter no máximo 255 caracteres.")
	@Email(message="Email inválido.")
	private String mail;
	
	public Client convertDTOToEntity() {
		return new ModelMapper().map(this, Client.class);
	}
}
