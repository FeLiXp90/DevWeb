package com.example.devweb.repositories;

import com.example.devweb.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<EnderecoModel, UUID> {
}

