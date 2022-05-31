package com.project.cotafacil.controller.client;

import java.util.Optional;

import javax.validation.Valid;

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

import com.project.cotafacil.exception.client.ClientInvalidUpdateException;
import com.project.cotafacil.exception.client.ClientNotFoundException;
import com.project.cotafacil.exception.client.ClientAlreadyExistingException;
import com.project.cotafacil.exception.user.UserFoundException;
import com.project.cotafacil.model.client.Client;
import com.project.cotafacil.model.dto.client.ClientDTO;
import com.project.cotafacil.model.dto.client.ClientRequestDTO;
import com.project.cotafacil.model.dto.response.Response;
import com.project.cotafacil.model.dto.user.UserDTO;
import com.project.cotafacil.model.dto.user.UserRequestDTO;
import com.project.cotafacil.model.user.User;
import com.project.cotafacil.service.client.ClientService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	@ApiOperation(value = "Rota que busca todos os usuários")
	public ResponseEntity<Response<Page<ClientDTO>>> findAll(@PageableDefault(page = 0, size = 10, sort = {"id"}) Pageable pageable) throws ClientNotFoundException{
		Response<Page<ClientDTO>> response = new Response<>();
		
		Page<Client> findClients = service.findByExcludedFalsePageable(pageable);
		
		if(findClients.isEmpty()) {
			throw new ClientNotFoundException("Nenhum cliente encontrado!");
		}
		
		Page<ClientDTO> users = findClients.map(u -> u.convertEntityToDTO());
		
		response.setData(users);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	@ApiOperation(value = "Rota que busca um Cliente")
	public ResponseEntity<Response<ClientDTO>> findById(@PathVariable Integer id) throws ClientNotFoundException{
		Response<ClientDTO> response = new Response<>();
		
		Optional<Client> client = service.findById(id);
		if(client.isEmpty()) {
			throw new ClientNotFoundException("Cliente não encontrado");
		}
		
		Client clientEntity = client.get();	
		response.setData(clientEntity.convertEntityToDTO());
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping
	@ApiOperation(value = "Rota que cria um novo Cliente")
	public ResponseEntity<Response<ClientDTO>> create(@Valid @RequestBody ClientRequestDTO clientDTO, BindingResult result) throws Exception{
		Response<ClientDTO> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
	
		
		Client client = clientDTO.convertDTOToEntity();
		Client clientToCreate = service.save(client);
		
		response.setData(clientToCreate.convertEntityToDTO());
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PutMapping
	@ApiOperation(value = "Rota que atualiza os dados do cliente")
	public ResponseEntity<Response<ClientDTO>> update(@Valid @RequestBody ClientRequestDTO clientDTO, BindingResult result) throws ClientInvalidUpdateException{
		Response<ClientDTO> response = new Response<>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.addErrorMsgToResponse(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Client client = clientDTO.convertDTOToEntity();
		
		Client clientToUpdate = service.update(client);
		response.setData(clientToUpdate.convertEntityToDTO());

		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	@ApiOperation(value = "Rota que deleta um Cliente")
	public ResponseEntity<Response<String>> delete(@PathVariable Integer id) throws ClientNotFoundException{
		Response<String> response = new Response<>();
		
		Optional<Client> client = service.findById(id);
		if(client.isEmpty()) {
			throw new ClientNotFoundException("Cliente não encontrado");
		}
		
		Client clienteEntity = client.get();	
		
		service.delete(clienteEntity);
		
		response.setData("Cliente deletado com sucesso!");
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}

