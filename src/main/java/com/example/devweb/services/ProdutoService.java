package com.example.devweb.services;

import com.example.devweb.dtos.ProdutoDto;
import com.example.devweb.models.ProdutoModel;
import com.example.devweb.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Component
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoModel saveProduct(ProdutoDto produtoDto){
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setNome(produtoDto.getNome());
        produtoModel.setValor(produtoDto.getValor());
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> getAllProducts(){
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> getOneProduct(UUID id){
        return produtoRepository.findById(id);
    }

    public ProdutoModel updateProduct(UUID id, ProdutoDto produtoDto){
        Optional<ProdutoModel> product0 = produtoRepository.findById(id);
        if(product0.isPresent()){
            ProdutoModel productModel = product0.get();
            productModel.setNome(produtoDto.getNome());
            productModel.setValor(produtoDto.getValor());
            return produtoRepository.save(productModel);
        }
        return null;
    }

    public void deleteProduct(UUID id) {
        produtoRepository.deleteById(id);
    }
}