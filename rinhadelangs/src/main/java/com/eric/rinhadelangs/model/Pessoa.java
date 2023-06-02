package com.eric.rinhadelangs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pessoa {
    @Id
    private UUID id;
    @Column(name = "apelido", nullable = false, unique = true)
    private String apelido;
    private String nome;
    private String nascimento;
    private String[] stack;
}
