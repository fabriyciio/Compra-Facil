package com.project.cotafacil.repository.admin;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cotafacil.model.admin.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	Optional<Category> findByDescriscao(String descriscao);
	
	Optional<Category> findBySolicitacao(String solitacao);
	
	Page<Category> findByExcludedFalse(Pageable pg);
}
