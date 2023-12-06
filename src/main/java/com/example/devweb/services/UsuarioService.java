package com.example.devweb.services;


import com.example.devweb.dtos.UsuarioDto;
import com.example.devweb.models.UsuarioModel;

import com.example.devweb.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UsuarioService extends EnderecoService{

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioModel saveUser(UsuarioDto usuarioDto) {
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(usuarioDto.getNome());
        usuarioModel.setDataNasc(usuarioDto.getDataNasc());
        usuarioModel.setEndereco(convertDtoToModel(usuarioDto.getEndereco()));
        return usuarioRepository.save(usuarioModel);
    }

    public List<UsuarioModel> getAllUsers() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> getOneUser(UUID id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioModel updateUser(UUID id, UsuarioDto usuarioDto) {
        Optional<UsuarioModel> user0 = usuarioRepository.findById(id);
        if (user0.isPresent()) {
            UsuarioModel usuarioModel = user0.get();
            usuarioModel.setNome(usuarioDto.getNome());
            usuarioModel.setDataNasc(usuarioDto.getDataNasc());
            usuarioModel.setEndereco(convertDtoToModel(usuarioDto.getEndereco()));
            return usuarioRepository.save(usuarioModel);
        }
        return null;
    }

    public void deleteUser(UUID id) {
        usuarioRepository.deleteById(id);
    }

}

