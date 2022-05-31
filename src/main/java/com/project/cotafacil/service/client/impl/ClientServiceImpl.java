package com.project.cotafacil.service.client.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.cotafacil.repository.client.*;
import com.project.cotafacil.exception.client.ClientInvalidUpdateException;
import com.project.cotafacil.exception.user.UserFoundException;
import com.project.cotafacil.exception.client.ClientAlreadyExistingException;
import com.project.cotafacil.model.client.*;
import com.project.cotafacil.model.user.User;
import com.project.cotafacil.service.client.*;
import com.project.cotafacil.service.user.UserService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository repository;
	
	@Autowired
	UserService userService;
	
	
	@Override
	public Optional<Client> findById(int id){
		return repository.findById(id);
	}
	
	@Override
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Client save(Client client) throws Exception{
		Client result = new Client();
		validadeClient(client);
		result = repository.save(client);
		if(!client.getUsers().isEmpty()) {
			for (User user : client.getUsers()) {
				user.setClient(result);
				userService.save(user);
			}
		}
		return result;
	}
	
	@Override
	public Client update(Client client) throws ClientInvalidUpdateException {
		Client clientFind = findClient(client.getId());
		client.setCreationDate(clientFind.getCreationDate());
		return repository.save(client);
	}
	
	@Override
	public void delete(Client client) {
		client.setExcluded(true);
		repository.save(client);
	}
	
	public Page<Client> findByExcludedFalsePageable(Pageable pg){
		return repository.findByExcludedFalse(pg);
	}
	
	private void validadeClient(Client client) throws ClientAlreadyExistingException  {
		if(validadeCnpj(client)) {
			throw new ClientAlreadyExistingException("Não foi possível salvar o cliente. Cnpj já existente");
		}
	}
	
	private boolean validadeCnpj(Client client) {
		Optional<Client> find = repository.findByCnpjAndExcludedFalse(client.getCnpj());
		return find.isPresent();
		
	}
	
	
	private Client findClient(int id) throws ClientInvalidUpdateException {
		Optional<Client> client = findById(id);
		if(!client.isPresent()) {
			throw new ClientInvalidUpdateException("Cliente não encontrado para realizar a atualização. ID:" + id);
		}
		return client.get();
	}

}
