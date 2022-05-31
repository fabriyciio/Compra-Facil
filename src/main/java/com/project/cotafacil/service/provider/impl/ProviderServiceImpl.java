package com.project.cotafacil.service.provider.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.cotafacil.repository.provider.ProviderRepository;

import com.project.cotafacil.exception.provider.ProviderAlreadyExistingException;
import com.project.cotafacil.model.provider.Provider;
import com.project.cotafacil.model.user.User;
import com.project.cotafacil.service.provider.ProviderService;
import com.project.cotafacil.service.user.UserService;


@Service
public class ProviderServiceImpl implements ProviderService {
	
	@Autowired
	ProviderRepository repository;
	@Autowired
	UserService userService;
		
	@Override
	public Optional<Provider> findById(int id){
		return repository.findById(id);
	}
	
	@Override
	public List<Provider> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Page<Provider> findByExcludedFalsePageable(Pageable pg){
		return repository.findByExcludedFalse(pg);
	}
	
	@Override
	@Transactional
	public Provider save(Provider provider) throws Exception{
		Provider result = new Provider();
		validadeProvider(provider);
		result = repository.save(provider);
		if(!provider.getUsers().isEmpty()) {
			for (User user : provider.getUsers()) {
				user.setProvider(result);
				userService.save(user);
			}
		}
		return result;
	}
	
	@Override
	public Provider update(Provider provider, Provider providerFind){
		provider.setActived(providerFind.isActived());
		provider.setExcluded(providerFind.isExcluded());
		provider.setCreationDate(providerFind.getCreationDate());
		return repository.save(provider);
	}
	
	@Override
	public void delete(Provider provider) {
		provider.setExcluded(true);
		repository.save(provider);
	}
	
	
	
	private void validadeProvider(Provider provider) throws  ProviderAlreadyExistingException {
		if(validadeCnpj(provider)) {
			throw new ProviderAlreadyExistingException("Não foi possível salvar o fornecedor. Cnpj já existente");
		}
	
	}
	
	
	private boolean validadeCnpj(Provider provider) {
		Optional<Provider> find = repository.findByCnpjAndExcludedFalse(provider.getCnpj());
		return find.isPresent();
		
	}
	
}
