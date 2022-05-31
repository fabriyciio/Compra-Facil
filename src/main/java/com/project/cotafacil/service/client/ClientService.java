package com.project.cotafacil.service.client;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.cotafacil.exception.client.ClientInvalidUpdateException;
import com.project.cotafacil.exception.user.UserFoundException;
import com.project.cotafacil.exception.client.ClientAlreadyExistingException;
import com.project.cotafacil.model.client.*;
import com.project.cotafacil.model.user.User;

public interface ClientService {
	
	Optional<Client> findById(int id);

	List<Client> findAll();

	Client save(Client client) throws Exception;
	
	Client update(Client client) throws ClientInvalidUpdateException;
	
	void delete(Client cliente);

	Page<Client> findByExcludedFalsePageable(Pageable pg);
	
	
}
