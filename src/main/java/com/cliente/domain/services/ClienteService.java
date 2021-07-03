package com.cliente.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cliente.domain.exceptions.ClienteNaoEncontradoException;
import com.cliente.domain.exceptions.EntidadeEmUsoException;
import com.cliente.domain.models.Cliente;
import com.cliente.domain.repositories.ClienteRepository;

@Service
public class ClienteService {

	private static final String MSG_CLIENTE_EM_USO 
	= "Cliente de código %d não pode ser removido, pois está em uso";

	
	@Autowired
	private ClienteRepository clienteRepository;
	

	@Transactional
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public List<Cliente> listar() {
		return this.clienteRepository.findAll();
	}
	
	public Cliente buscarOuFalhar(Long clienteId) {
		return this.clienteRepository.findById(clienteId)
			.orElseThrow(() -> new ClienteNaoEncontradoException(clienteId));
	}	

	
	
	@Transactional
	public void excluir(Long clienteId) {
		try {
			this.clienteRepository.deleteById(clienteId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new ClienteNaoEncontradoException(clienteId);
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format(MSG_CLIENTE_EM_USO, clienteId));
		}
	}	
}
