package com.cliente.domain.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cliente.domain.models.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	public List<Cliente> findAllById(Long id);
	
	public Page<Cliente> findAllById(Long id, Pageable pageable);
	
	@Transactional
	@Modifying
	@Query("UPDATE clientes SET nome = ?2 WHERE id = ?1")
	public int updateClienteNome(Long id, String nome);

	@Transactional
	@Modifying
	@Query("UPDATE clientes SET ativo = ?2 WHERE id = ?1")
	public int updateClienteAtivo(Long id, Boolean ativo);

}
