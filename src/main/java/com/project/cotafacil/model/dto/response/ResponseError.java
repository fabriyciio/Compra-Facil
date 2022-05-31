package com.project.cotafacil.model.dto.response;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class ResponseError {
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="Timestamp não pode ser nulo")
	private LocalDateTime timestamp;
	
	@NotNull(message="Os detalhes não podem ser nulos")
    private String details;

}
