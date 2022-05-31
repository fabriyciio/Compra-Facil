package com.project.cotafacil.repository.client;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cotafacil.model.client.*;

public interface ClientRepository extends JpaRepository<Client, Integer> {

	Page<Client> findByExcludedFalse(Pageable pg);
	
	Optional<Client> findByCnpjAndExcludedFalse(String cnpj);

}
