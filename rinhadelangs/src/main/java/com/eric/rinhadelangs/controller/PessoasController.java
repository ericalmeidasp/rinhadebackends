package com.eric.rinhadelangs.controller;

import com.eric.rinhadelangs.model.Pessoa;
import com.eric.rinhadelangs.model.dto.PessoaRequestDTO;
import com.eric.rinhadelangs.service.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PessoasController {
    private final PessoaService pessoaService;

    @PostMapping("/pessoas")
    public ResponseEntity<Void> store(@RequestBody @Validated PessoaRequestDTO pessoaRequestDTO) {
        try {
            Pessoa pessoa = pessoaService.create(pessoaRequestDTO);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(pessoa.getId())
                    .toUri();

            return ResponseEntity.created(location).build();
        } catch (Exception exception) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @GetMapping("/pessoas")
    public ResponseEntity<List<Pessoa>> index(@RequestParam String t) {
        return ResponseEntity.ok(pessoaService.findByArgs(t));
    }

    @GetMapping("/pessoas/{id}")
    public ResponseEntity<Pessoa> show(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(pessoaService.findById(id));
        } catch (Exception exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/contagem-pessoas")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(pessoaService.count());
    }
}
