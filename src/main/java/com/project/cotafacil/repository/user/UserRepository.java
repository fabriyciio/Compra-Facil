package com.project.cotafacil.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.cotafacil.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByMail(String email);

}
