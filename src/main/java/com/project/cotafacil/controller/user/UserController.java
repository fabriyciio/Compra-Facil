package com.project.cotafacil.controller.user;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cotafacil.exception.user.UserFoundException;
import com.project.cotafacil.exception.user.UserInvalidUpdateException;
import com.project.cotafacil.model.dto.response.Response;
import com.project.cotafacil.model.dto.user.UserDTO;
import com.project.cotafacil.model.dto.user.UserRequestDTO;
import com.project.cotafacil.model.dto.user.UserUpdateDTO;
import com.project.cotafacil.model.user.User;
import com.project.cotafacil.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

import java.util.Optional;

import javax.validation.Valid;

@Log4j2
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	@ApiOperation(value = "Rota que busca todos os usuários ativos")
	public ResponseEntity<Response<Page<UserDTO>>> findAll(@PageableDefault(page = 0, size = 10, sort = {"id"}) Pageable pageable) throws UserFoundException{
		Response<Page<UserDTO>> response = new Response<>();
		
		Page<User> findUsers = service.findByExcludedFalsePageable(pageable);
		
		if(findUsers.isEmpty()) {
			throw new UserFoundException("Nenhum usuário encontrado!");
		}
		
		Page<UserDTO> users = findUsers.map(u -> u.convertEntityToDTO());
		
		response.setData(users);
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	@ApiOperation(value = "Rota que busca um usuário")
	public ResponseEntity<Response<UserDTO>> findById(@PathVariable Integer id) throws UserFoundException{
		Response<UserDTO> response = new Response<>();
		
		Optional<User> user = service.findById(id);
		if(user.isEmpty()) {
			throw new UserFoundException("Usuário não encontrado");
		}
		
		User userEntity = user.get();	
		response.setData(userEntity.convertEntityToDTO());
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping
	@ApiOperation(value = "Rota que cria um novo usuário")
	public ResponseEntity<Response<UserDTO>> create(@Valid @RequestBody UserRequestDTO userDTO, BindingResult result) throws UserFoundException{
		Response<UserDTO> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		User user = userDTO.convertDTOToEntity();
		User userToCreate = service.save(user);
		
		response.setData(userToCreate.convertEntityToDTO());
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PutMapping
	@ApiOperation(value = "Rota que atualiza os dados do usuário")
	public ResponseEntity<Response<UserDTO>> update(@Valid @RequestBody UserUpdateDTO userDTO, BindingResult result) throws UserFoundException, UserInvalidUpdateException{
		Response<UserDTO> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		User user = userDTO.convertDTOToEntity();
		User userToUpdate = service.update(user);
		
		response.setData(userToUpdate.convertEntityToDTO());
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	@ApiOperation(value = "Rota que deleta um usuário")
	public ResponseEntity<Response<String>> delete(@PathVariable Integer id) throws UserFoundException{
		Response<String> response = new Response<>();
		
		Optional<User> user = service.findById(id);
		if(user.isEmpty()) {
			throw new UserFoundException("Usuário não encontrado");
		}
		
		User userEntity = user.get();	
		service.delete(userEntity);
		
		response.setData("Usuário deletado com sucesso!");
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
