package com.example.devweb.services;

import com.example.devweb.dtos.EnderecoDto;
import com.example.devweb.models.EnderecoModel;
import com.example.devweb.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public EnderecoModel saveEnd(EnderecoDto enderecoDto){
        EnderecoModel enderecoModel = new EnderecoModel();
        enderecoModel.setLogradouro(enderecoDto.getLogradouro());
        enderecoModel.setBairro(enderecoDto.getBairro());
        enderecoModel.setCidade(enderecoDto.getCidade());
        enderecoModel.setEstado(enderecoDto.getEstado());
        enderecoModel.setNumero(enderecoDto.getNumero());
        return enderecoRepository.save(enderecoModel);
    }
    public EnderecoModel convertDtoToModel(EnderecoDto enderecoDto) {
        EnderecoModel enderecoModel = new EnderecoModel();
        enderecoModel.setLogradouro(enderecoDto.getLogradouro());
        enderecoModel.setBairro(enderecoDto.getBairro());
        enderecoModel.setCidade(enderecoDto.getCidade());
        enderecoModel.setEstado(enderecoDto.getEstado());
        enderecoModel.setNumero(enderecoDto.getNumero());
        return enderecoModel;
    }

    public List<EnderecoModel> getAllEnds(){
        return enderecoRepository.findAll();
    }

    public Optional<EnderecoModel> getOneEnd(UUID id){
        return enderecoRepository.findById(id);
    }

    public EnderecoModel updateEnd(UUID id, EnderecoDto enderecoDto){
        Optional<EnderecoModel> end0 = enderecoRepository.findById(id);
        if(end0.isPresent()){
            EnderecoModel enderecoModel = end0.get();
            enderecoModel.setLogradouro(enderecoDto.getLogradouro());
            enderecoModel.setBairro(enderecoDto.getBairro());
            enderecoModel.setCidade(enderecoDto.getCidade());
            enderecoModel.setEstado(enderecoDto.getEstado());
            enderecoModel.setNumero(enderecoDto.getNumero());
            return enderecoRepository.save(enderecoModel);
        }
        return null;
    }

    public void deleteUser(UUID id) {
        enderecoRepository.deleteById(id);
    }
}