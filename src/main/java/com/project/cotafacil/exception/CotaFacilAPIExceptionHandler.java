package com.project.cotafacil.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ServerErrorException;

import com.fasterxml.jackson.core.JsonParseException;
import com.project.cotafacil.exception.user.UserMailFoundException;
import com.project.cotafacil.exception.admin.CategoryFoundException;
import com.project.cotafacil.exception.client.ClientNotFoundException;
import com.project.cotafacil.exception.provider.ProviderFoundException;
import com.project.cotafacil.exception.client.ClientAlreadyExistingException;
import com.project.cotafacil.exception.client.ClientInvalidUpdateException;
import com.project.cotafacil.exception.user.UserFoundException;
import com.project.cotafacil.exception.user.UserInvalidUpdateException;
import com.project.cotafacil.model.dto.response.Response;

@ControllerAdvice
public class CotaFacilAPIExceptionHandler<T> {
	
	@ExceptionHandler(value = { CotaFacilInvalidUpdateException.class })
    protected ResponseEntity<Response<T>> handleCotaFacilInvalidUpdateException(CotaFacilInvalidUpdateException exception) {
		
		Response<T> response = new Response<>();
		response.addErrorMsgToResponse(exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }
	
	
	@ExceptionHandler(value = { UserFoundException.class })
    protected ResponseEntity<Response<T>> handleUserNotFoundException(UserFoundException exception) {
		
		Response<T> response = new Response<>();
		response.addErrorMsgToResponse(exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		
    }
	
	@ExceptionHandler(value = { ProviderFoundException.class })
    protected ResponseEntity<Response<T>> handleProviderNotFoundException(ProviderFoundException exception) {
		
		Response<T> response = new Response<>();
		response.addErrorMsgToResponse(exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	
	@ExceptionHandler(value = { ClientNotFoundException.class })
    protected ResponseEntity<Response<T>> handleClientNotFoundException(ClientNotFoundException exception) {
		
		Response<T> response = new Response<>();
		response.addErrorMsgToResponse(exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
	
	
	
	@ExceptionHandler(value = { HttpClientErrorException.Conflict.class })
    protected ResponseEntity<Response<T>> handleConflictException(HttpClientErrorException exception) {
		
		Response<T> response = new Response<>();
		response.addErrorMsgToResponse(exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
	
	@ExceptionHandler(value = { HttpMessageNotReadableException.class, JsonParseException.class, NotParsableContentException.class })
    protected ResponseEntity<Response<T>> handleMessageNotReadableException(Exception exception) {
		
		Response<T> response = new Response<>();
		response.addErrorMsgToResponse(exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
    }
	
	@ExceptionHandler(value = { HttpClientErrorException.TooManyRequests.class })
    protected ResponseEntity<Response<T>> handleTooManyRequestException(HttpClientErrorException exception) {
		
		Response<T> response = new Response<>();
		response.addErrorMsgToResponse(exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(response);
    }
	
	@ExceptionHandler(value = { ServerErrorException.class })
    protected ResponseEntity<Response<T>> handleAPIException(ServerErrorException exception) {
		
		Response<T> response = new Response<>();
		response.addErrorMsgToResponse(exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
	
	@ExceptionHandler(value = { AuthenticationException.class })
    protected ResponseEntity<Response<T>> handleAuthenticationException(AuthenticationException exception) {
		
		Response<T> response = new Response<>();
		response.addErrorMsgToResponse(exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
	
	@ExceptionHandler(value = { UserMailFoundException.class })
    protected ResponseEntity<Response<T>> handleUserMailFound(UserMailFoundException exception) {
		
		Response<T> response = new Response<>();
		response.addErrorMsgToResponse(exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
	
	@ExceptionHandler(value = { ClientAlreadyExistingException.class })
    protected ResponseEntity<Response<T>> handleClientAlreadyExisting(ClientAlreadyExistingException exception) {
		
		Response<T> response = new Response<>();
		response.addErrorMsgToResponse(exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
	
	@ExceptionHandler(value = { UserInvalidUpdateException.class })
    protected ResponseEntity<Response<T>> handleUserInvalidUpdateException(UserInvalidUpdateException exception) {
		
		Response<T> response = new Response<>();
		response.addErrorMsgToResponse(exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }
	
	@ExceptionHandler(value = { ClientInvalidUpdateException.class })
    protected ResponseEntity<Response<T>> handleClientInvalidUpdateException(ClientInvalidUpdateException exception) {
		
		Response<T> response = new Response<>();
		response.addErrorMsgToResponse(exception.getLocalizedMessage());
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

}
