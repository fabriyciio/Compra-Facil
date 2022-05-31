package com.project.cotafacil.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.cotafacil.exception.user.UserFoundException;
import com.project.cotafacil.exception.user.UserInvalidUpdateException;
import com.project.cotafacil.model.user.User;

public interface UserService {
	
	Optional<User> findById(int id);

	List<User> findAll();

	User save(User user) throws UserFoundException;
	
	User update(User user) throws UserInvalidUpdateException;

	Optional<User> findByMail(String mail);
	
	Page<User> findByExcludedFalsePageable(Pageable pg);
	
	void delete(User user);
	
	
}
