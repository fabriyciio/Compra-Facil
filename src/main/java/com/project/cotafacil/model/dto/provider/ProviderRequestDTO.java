package com.project.cotafacil.model.dto.provider;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.cotafacil.model.provider.Provider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProviderRequestDTO {
	
	private int id;
	
	@NotNull(message = "O nome não pode ser nulo.")
	@Length(min=3, max=255, message="O nome deve conter entre 3 e 255 caracteres.")
	private String name;
	
	@NotNull(message = "O email não pode ser nulo.")
	@Length(max=255, message="O email deve conter no máximo 255 caracteres.")
	private String mail;
	
	@NotNull(message = "O cpf não pode ser nulo.")
	@Length(max=11, message="O cpf deve conter no máximo 11 caracteres.")
	private String cpf;
	
	@NotNull(message = "O telefone não pode ser nulo.")
	@Length(max=11, message="O telefone deve conter no máximo 11 caracteres.")
	private String phone;
	
	@NotNull(message = "A senha não pode ser nulo.")
	@Length(max=11, message="A senha deve conter no máximo 11 caracteres.")
	private String password;
	
	public Provider convertDTOToEntity() {
		return new ModelMapper().map(this, Provider.class);
	}
	
}
