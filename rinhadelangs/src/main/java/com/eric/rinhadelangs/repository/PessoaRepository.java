package com.eric.rinhadelangs.repository;

import com.eric.rinhadelangs.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, UUID> {
    List<Pessoa> findTop50ByNomeContaining(String nome);
}
