package com.project.cotafacil.model.dto.response;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class ResponseError {
	
	@NotNull(message="Timestamp não pode ser nulo")
	private LocalDateTime timestamp;
	
	@NotNull(message="Os detalhes não podem ser nulos")
    private String details;

}
