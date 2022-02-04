package com.trabalho_lp.trabalho_lp.repository;

import org.springframework.data.repository.CrudRepository;
import com.trabalho_lp.trabalho_lp.model.Funcionario;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, String>{
    Funcionario findById(long id);
}
