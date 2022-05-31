package com.project.cotafacil.service.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.cotafacil.exception.admin.CategoryFoundException;
import com.project.cotafacil.exception.admin.CategoryInvalidUpdateException;
import com.project.cotafacil.model.admin.Category;;

public interface CategoryService {
	
	Optional<Category> findById(int id);

	List<Category> findAll();

	Category save(Category category) throws CategoryFoundException;
	
	Category update(Category category) throws CategoryInvalidUpdateException;

	
	
	Page<Category> findByExcludedFalsePageable(Pageable pg);
	
	void delete(Category category); 
	
	
	
}
