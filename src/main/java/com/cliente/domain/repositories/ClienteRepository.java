package com.cliente.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cliente.domain.models.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	

}
