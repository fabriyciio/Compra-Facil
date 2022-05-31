package com.project.cotafacil.model.dto.address;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
	
	private int id;	
	
	@NotNull(message = "O endereço não pode ser nulo.")
	@Length(max=255, message="O endereço deve conter no máximo 255 caracteres.")
	private String address;
	
	@NotNull(message = "O número não pode ser nulo.")
	@Length(max=5, message="O número deve conter no máximo 5 caracteres.")
	private String number;
	
	@NotNull(message = "O cep não pode ser nulo.")
	@Length(min=8, max=8, message="O cep deve conter 8 caracteres.")
	private String cep;
	
	@Length(max=8, message="O número deve conter no máximo 255 caracteres.")
	private String complement;
	
	@NotNull(message = "O bairro não pode ser nulo.")
	@Length(max=255, message="O bairro deve conter no máximo 255 caracteres.")
	private String district;
	
	@NotNull(message = "A cidade não pode ser nulo.")
	@Length(max=255, message="A cidade deve conter no máximo 255 caracteres.")
	private String city;
	
	@NotNull(message = "O estado não pode ser nulo.")
	@Length(max=255, message="O estado deve conter no máximo 255 caracteres.")
	private String state;
}
