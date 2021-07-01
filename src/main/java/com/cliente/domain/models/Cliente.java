package com.cliente.domain.models;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.br.CPF;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name =  "clientes")
public class Cliente {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do cliente deve ser preenchido")
	@Column(nullable = false)
	private String nome;
	
	@CPF(message = "CPF inválido")
	@Column(nullable = false)
	private String cpf;
	
    @NotBlank
	@Column(nullable = false)
	private String nomeMae;
    
    @NotNull
    @Column(nullable = false, columnDefinition = "datetime")
    private LocalDate dataNascimento;
    
    
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
//	private LocalDateTime dataCadastro;    
	private OffsetDateTime dataCadastro;
	
    @NotNull
    private boolean ativo = true;
    


}
