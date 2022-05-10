package com.project.cotafacil.controller.client;

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
import com.project.cotafacil.model.dto.client.*;
import com.project.cotafacil.model.client.*;
import com.project.cotafacil.service.client.*;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
	
	@Autowired
	private ClientService service;
	

	@Autowired
	public ClientController(ClientService clientService) {
		this.service = clientService;
	}
	
	
	@GetMapping
	@ApiOperation(value = "Rota que busca todos os usuários")
	public ResponseEntity<Response<List<ClientDTO>>> findAll(BindingResult result){
		Response<List<ClientDTO>> response = new Response<>();
		
		List<Client> findClients = service.findAll();
		List<ClientDTO> clients = new ArrayList<>();
		
		findClients.stream().forEach(client -> {
			clients.add(client.convertEntityToDTO());
		});
		response.setData(clients);
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}

