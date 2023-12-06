package com.example.devweb.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "TB_ENDERECO")
public class EnderecoModel extends RepresentationModel<EnderecoModel> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String numero;
}