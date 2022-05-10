package com.project.cotafacil.service.user;

import java.util.List;
import java.util.Optional;

import com.project.cotafacil.model.user.User;

public interface UserService {
	
	Optional<User> findById(Long id);

	List<User> findAll();

	User save(User user);

	Optional<User> findByMail(String mail);
	
	
}
