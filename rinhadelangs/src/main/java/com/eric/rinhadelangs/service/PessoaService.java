package com.eric.rinhadelangs.service;

import com.eric.rinhadelangs.model.Pessoa;
import com.eric.rinhadelangs.model.dto.PessoaRequestDTO;
import com.eric.rinhadelangs.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    public Pessoa create(PessoaRequestDTO pessoaRequestDTO) {
        Pessoa pessoa = Pessoa.builder()
                .id(UUID.randomUUID())
                .apelido(pessoaRequestDTO.getApelido())
                .nascimento(pessoaRequestDTO.getNascimento())
                .nome(pessoaRequestDTO.getNome())
                .stack(pessoaRequestDTO.getStack())
                .build();
        pessoaRepository.save(pessoa);
        return pessoa;
    }

    public Pessoa findById(UUID id) {
        return pessoaRepository.findById(id).orElseThrow();
    }

    public List<Pessoa> findByArgs(String id) {
        return pessoaRepository.findTop50ByNomeContaining(id);
    }

    public Long count() {
        return pessoaRepository.count();
    }
}
