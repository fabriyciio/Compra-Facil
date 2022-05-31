package com.project.cotafacil.model.dto.admin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.cotafacil.model.admin.Category;
import com.project.cotafacil.model.user.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {
	
	private Long id;
	
	@NotNull(message = "O nome não pode ser nulo.")
	@Length(min=3, max=255, message="O nome deve conter entre 3 e 255 caracteres.")
	private String descriscao;
	
	@NotNull(message = "O email não pode ser nulo.")
	@Length(max=255, message="O email deve conter no máximo 255 caracteres.")
	private String solicitacao;
	
	
	public Category convertDTOToEntity() {
		return new ModelMapper().map(this, Category.class);
	}
}
