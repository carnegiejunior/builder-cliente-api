package com.cliente.api.models.mixins;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class ClienteMixin {
	
	@JsonProperty("data-nascimento")
	private LocalDate dataNascimento;
	
	@JsonProperty("nome-mae")
	private String nomeMae;
	
	@JsonIgnoreProperties(allowGetters = true)
	@JsonProperty("data-cadastro")
	private OffsetDateTime dataCadastro;
		
	@JsonIgnoreProperties(allowGetters = true)
	@JsonProperty("data-atualizacao")
	private OffsetDateTime dataAtualizacao;	
	
	@JsonIgnoreProperties(allowGetters = true)
	private int idade;	
}
