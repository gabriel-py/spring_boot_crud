package com.trabalho_lp.trabalho_lp.repository;

import org.springframework.data.repository.CrudRepository;

import com.trabalho_lp.trabalho_lp.model.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String>{
    Cliente findByCodigo(long codigo);
}