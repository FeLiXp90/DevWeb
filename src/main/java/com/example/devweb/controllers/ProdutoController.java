package com.example.devweb.controllers;

import com.example.devweb.dtos.ProdutoDto;
import com.example.devweb.models.ProdutoModel;

import com.example.devweb.services.ProdutoService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/products")
    public ResponseEntity<ProdutoModel> saveProduct(@RequestBody @Valid ProdutoDto produtoDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.saveProduct(produtoDto));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProdutoModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getAllProducts());
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") UUID id){
        Optional<ProdutoModel> product0 = produtoService.getOneProduct(id);
        if(product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProdutoDto produtoDto) {
        ProdutoModel updatedProduct = produtoService.updateProduct(id, produtoDto);
        if(updatedProduct == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id) {
        produtoService.deleteProduct(id);
        return ResponseEntity.status((HttpStatus.OK)).body("Product deleted successfully");
    }
}