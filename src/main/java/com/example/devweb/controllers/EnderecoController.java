package com.example.devweb.controllers;

import com.example.devweb.dtos.EnderecoDto;
import com.example.devweb.models.EnderecoModel;

import com.example.devweb.services.EnderecoService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/enderecos")
    public ResponseEntity<EnderecoModel> saveEnd(@RequestBody @Valid EnderecoDto enderecoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.saveEnd(enderecoDto));
    }

    @GetMapping("/enderecos")
    public ResponseEntity<List<EnderecoModel>> getAllEnds(){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.getAllEnds());
    }

    @GetMapping("enderecos/{id}")
    public ResponseEntity<Object> getOneEnd(@PathVariable(value="id") UUID id){
        Optional<EnderecoModel> product0 = enderecoService.getOneEnd(id);
        if(product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
    }

    @PutMapping("/enderecos/{id}")
    public ResponseEntity<Object> updateEnd(@PathVariable(value = "id") UUID id, @RequestBody @Valid EnderecoDto enderecoDto) {
        EnderecoModel updatedProduct = enderecoService.updateEnd(id, enderecoDto);
        if(updatedProduct == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("/enderecos/{id}")
    public ResponseEntity<Object> deleteEnd(@PathVariable(value = "id") UUID id) {
        enderecoService.deleteEnd(id);
        return ResponseEntity.status((HttpStatus.OK)).body("Product deleted successfully");
    }
}