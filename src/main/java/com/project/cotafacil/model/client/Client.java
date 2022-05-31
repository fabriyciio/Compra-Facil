package com.project.cotafacil.model.client;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.project.cotafacil.enumeration.RoleEnum;
import com.project.cotafacil.model.address.Address;
import com.project.cotafacil.model.dto.client.*;
import com.project.cotafacil.model.user.User;

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
	private int id;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "nome")
	private String name;

	@Column(name= "razao_social")
	private String socialreason;
	
	@Column(name = "solicitacao")
	private boolean request;
	
	@Column(name = "ativo")
	private boolean actived;
	
	@Column(name = "excluido")
	private boolean excluded;

	@Column(name = "data_criacao")
	private LocalDateTime creationDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="endereco_id", referencedColumnName = "id")
	private Address address;
	
	@OneToMany(mappedBy="client")
    private List<User> users;
	
	@PrePersist
    public void prePersist() {
		creationDate = LocalDateTime.now();
		actived = true;
		excluded = false;
    }
	
	public ClientDTO convertEntityToDTO() {
		return new ModelMapper().map(this, ClientDTO.class);
	}
	
}
