package com.cliente.api.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClienteRepresentationModel {

	private Long id;
	private String nome;
	private String idade;
	
	public ClienteRepresentationModel(Long id, String nome, String idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}
}
