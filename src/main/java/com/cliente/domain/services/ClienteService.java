package com.cliente.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cliente.domain.models.Cliente;
import com.cliente.domain.repositories.ClienteRepository;

@Service
public class ClienteService {


	@Autowired
	private ClienteRepository clienteRepository;
	

	@Transactional
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}

	
	//	@Transactional
//	public void excluir(Long cidadeId) {
//		try {
//			cidadeRepository.deleteById(cidadeId);
//			cidadeRepository.flush();
//			
//		} catch (EmptyResultDataAccessException e) {
//			throw new CidadeNaoEncontradaException(cidadeId);
//		
//		} catch (DataIntegrityViolationException e) {
//			throw new EntidadeEmUsoException(
//				String.format(MSG_CIDADE_EM_USO, cidadeId));
//		}
//	}	
}
