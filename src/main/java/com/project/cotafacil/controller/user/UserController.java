package com.project.cotafacil.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cotafacil.model.dto.response.Response;
import com.project.cotafacil.model.dto.user.UserDTO;
import com.project.cotafacil.model.user.User;
import com.project.cotafacil.service.user.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService service;
	

	@Autowired
	public UserController(UserService userService) {
		this.service = userService;
	}
	
	
	@GetMapping
	@ApiOperation(value = "Rota que busca todos os usuários")
	public ResponseEntity<Response<List<UserDTO>>> findAll(){
		Response<List<UserDTO>> response = new Response<>();
		
		List<User> findUsers = service.findAll();
		List<UserDTO> users = new ArrayList<>();
		
		findUsers.stream().forEach(user -> {
			users.add(user.convertEntityToDTO());
		});
		response.setData(users);
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
