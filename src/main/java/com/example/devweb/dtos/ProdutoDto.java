package com.example.devweb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoDto {

    @NotBlank
    private String nome;

    @NotNull
    private BigDecimal valor;
}
