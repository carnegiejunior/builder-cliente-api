package com.cliente.domain.models;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.br.CPF;

import com.cliente.api.models.ClienteRepresentationModel;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "clientes")
public class Cliente {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INT_CLIENTE_ID", nullable = false)
	private Long id;

	@NotBlank(message = "O nome do cliente deve ser preenchido")
	@Column(name = "STR_CLIENTE_NOME", nullable = false, length = 50)
//	@Max(value = 50, message = "Nome do cliente deve conter no máximo 50 caracteres")
	private String nome;

	@NotNull
	@CPF(message = "CPF inválido")
	@Column(name = "STR_CLIENTE_CPF", nullable = false)
	private String cpf;

	@NotBlank
	@Column(name = "STR_CLIENTE_NOME_MAE", nullable = false)
	private String nomeMae;

	@NotNull
	@Column(name = "DT_CLIENTE_DATA_NASCIMENTO", nullable = false, columnDefinition = "datetime")
	private LocalDate dataNascimento;

	@CreationTimestamp
	@Column(name = "DT_CLIENTE_DATA_CADASTRO", nullable = false, columnDefinition = "datetime")
	private OffsetDateTime dataCadastro;
		
	@UpdateTimestamp
	@Column(name = "DT_CLIENTE_DATA_ATUALIZACAO", nullable = false, columnDefinition = "datetime")
	private OffsetDateTime dataAtualizacao;	

	@Transient
	private String idade;
	
	@PostPersist
	@PostLoad
	private void onLoad() {
		this.idade = String.format("%d anos, %d meses e %d dias", 
				Period.between(dataNascimento, LocalDate.now()).getYears(),
				Period.between(dataNascimento, LocalDate.now()).getMonths(),
				Period.between(dataNascimento, LocalDate.now()).getDays()
				);
		
	}
	
	public ClienteRepresentationModel toModel() {
		return new ClienteRepresentationModel(this.id,this.nome,this.idade);
	}

}
