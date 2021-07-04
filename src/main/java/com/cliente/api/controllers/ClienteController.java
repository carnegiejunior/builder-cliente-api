package com.cliente.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.api.models.ClienteUpdateNomeDTO;
import com.cliente.api.models.pagination.PageModel;
import com.cliente.api.models.pagination.PageRequestModel;
import com.cliente.domain.models.Cliente;
import com.cliente.domain.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes", produces = { "application/json" })
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<PageModel<Cliente>> listarTodos(
		
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "5") int size
			
			) 
	{
		
		PageRequestModel pr = new PageRequestModel(page, size);
		PageModel<Cliente> pm = this.clienteService.listAllOnLazyMode(pr);
		if (pm.getElements().size() > 0) {
			return ResponseEntity.ok(pm);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

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
	public Cliente atualizar(@PathVariable Long clienteId, @RequestBody @Valid Cliente cliente) {
		
		Cliente clienteAtual = this.clienteService.buscarOuFalhar(clienteId);

		BeanUtils.copyProperties(cliente, clienteAtual, "id", "dataCadastro", "dataAtualizacao");

		return this.clienteService.salvar(clienteAtual);
		
	}
	
	@PatchMapping("/{clienteId}/nome")
	public ResponseEntity<?> atualizarNome(@PathVariable(name="clienteId") Long id, @RequestBody ClienteUpdateNomeDTO clienteUpdateNomeDTO){
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNome(clienteUpdateNomeDTO.getNome());
		this.clienteService.clienteUpdateNome(cliente);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{clienteId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long clienteId) {
		this.clienteService.excluir(clienteId);
	}

}
