package com.eric.rinhadelangs.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PessoaRequestDTO {
    @NotBlank
    private String apelido;
    @NotBlank
    private String nome;
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
    private String nascimento;
    private String[] stack;
}
