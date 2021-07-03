package com.cliente.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.domain.models.Cliente;
import com.cliente.domain.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes",produces = {"application/json"})
public class ClienteController {

	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listar() {
		return this.clienteService.listar();
	}

	@GetMapping("/{clienteId}")
	public Cliente buscarPorId(@PathVariable Long clienteId) {
		return this.clienteService.buscarOuFalhar(clienteId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody @Valid Cliente cliente) {
		return this.clienteService.salvar(cliente);
	}
	
	@PutMapping("/{clienteId}")
	public Cliente atualizar(@PathVariable Long clienteId,
			@RequestBody @Valid Cliente cliente) {
		Cliente clienteAtual = this.clienteService.buscarOuFalhar(clienteId);
		
		BeanUtils.copyProperties(cliente, clienteAtual, "id");
		
		return this.clienteService.salvar(clienteAtual);
	}
	
	@DeleteMapping("/{clienteId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long clienteId) {
		this.clienteService.excluir(clienteId);
	}
	
}
