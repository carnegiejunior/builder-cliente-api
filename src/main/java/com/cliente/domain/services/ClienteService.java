package com.cliente.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cliente.api.models.pagination.PageModel;
import com.cliente.api.models.pagination.PageRequestModel;
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


	public PageModel<Cliente> listAllOnLazyMode(PageRequestModel pageRequestModel) {
		Pageable pageable = PageRequest.of(pageRequestModel.getPage(), pageRequestModel.getSize());
		
		Page<Cliente> page = this.clienteRepository.findAll(pageable);
		
		PageModel<Cliente> pageModel = new PageModel<>((int) page.getTotalElements(),page.getSize(),page.getTotalPages(),page.getContent());
		return pageModel;
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


	public int clienteUpdateNome(Cliente cliente) {
		return this.clienteRepository.updateClienteNome(cliente.getId(), cliente.getNome());
	}


	}
