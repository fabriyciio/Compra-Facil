package com.project.cotafacil.model.client;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.project.cotafacil.enumeration.RoleEnum;
import com.project.cotafacil.model.dto.client.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class Client implements Serializable {
	
	private static final long serialVersionUID = -8553864086130686408L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String name;

	@Column(name = "email")
	private String mail;
	
	@Column(name = "senha")
	private String password;
	

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "telefone")
	private String phone;

	@Column(name = "ativo")
	private boolean actived;
	
	@Column(name = "excluido")
	private boolean excluded;

	@Column(name = "data_criacao")
	private LocalDateTime creationDate;
	
	
	@PrePersist
    public void prePersist() {
		creationDate = LocalDateTime.now();
    }
	
	public ClientDTO convertEntityToDTO() {
		return new ModelMapper().map(this, ClientDTO.class);
	}
	
}
