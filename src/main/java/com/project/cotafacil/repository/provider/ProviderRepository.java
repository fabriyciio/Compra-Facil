package com.project.cotafacil.repository.provider;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cotafacil.model.client.Client;
import com.project.cotafacil.model.provider.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {
	
	
	Page<Provider> findByExcludedFalse(Pageable pg);
	
	Optional<Provider> findByCnpjAndExcludedFalse(String cnpj);
}
