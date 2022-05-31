package com.project.cotafacil.model.dto.client;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.cotafacil.model.client.Client;
import com.project.cotafacil.model.dto.address.AddressDTO;
import com.project.cotafacil.model.dto.user.UserRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientUpdateDTO {
	
	public int id;
	
	@NotNull(message = "O nome não pode ser nulo.")
	@Length(min=14, max=14, message="Cnpj deve conter 14 caracteres.")
	private String cnpj;
	
	@NotNull(message = "O nome não pode ser nulo.")
	@Length(min=3, max=255, message="O nome deve conter entre 3 e 255 caracteres.")
	private String name;

	@NotNull(message = "A razão social não pode ser nula.")
	@Length(min=3, max=255, message="A razão social deve conter entre 3 e 255 caracteres.")
	private String socialreason;
	
	private AddressDTO address;
	
	private List<UserRequestDTO> users;
	
	public Client convertDTOToEntity() {
		return new ModelMapper().map(this, Client.class);
	}
}

