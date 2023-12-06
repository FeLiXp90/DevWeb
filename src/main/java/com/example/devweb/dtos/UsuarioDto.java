package com.example.devweb.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioDto {

    @NotBlank
    private String nome;


    private Date dataNasc;


    private EnderecoDto endereco;
}
