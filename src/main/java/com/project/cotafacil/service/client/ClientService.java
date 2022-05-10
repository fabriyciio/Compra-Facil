package com.project.cotafacil.service.client;

import java.util.List;
import java.util.Optional;

import com.project.cotafacil.model.client.*;

public interface ClientService {
	
	Optional<Client> findById(Long id);

	List<Client> findAll();

	Client save(Client client);

	Optional<Client> findByMail(String mail);
	
	
}
