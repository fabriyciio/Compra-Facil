package com.project.cotafacil.model.address;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "endereco")
public class Address implements Serializable {
	
	private static final long serialVersionUID = 2896531206623486940L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "logradouro")
	private String address;
	
	@Column(name = "numero")
	private String number;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "complemento")
	private String complement;
	
	@Column(name = "bairro")
	private String district;
	
	@Column(name = "cidade")
	private String city;
	
	@Column(name = "estado")
	private String state;
	
}
