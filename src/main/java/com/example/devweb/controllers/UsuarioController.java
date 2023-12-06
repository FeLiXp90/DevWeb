package com.example.devweb.controllers;

        import com.example.devweb.dtos.UsuarioDto;
        import com.example.devweb.models.UsuarioModel;

        import com.example.devweb.services.UsuarioService;
        import jakarta.validation.Valid;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.Optional;
        import java.util.UUID;


@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioModel> saveUser(@RequestBody @Valid UsuarioDto usuarioDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUser(usuarioDto));
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioModel>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getAllUsers());
    }

    @GetMapping("usuarios/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value="id") UUID id){
        Optional<UsuarioModel> product0 = usuarioService.getOneUser(id);
        if(product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") UUID id, @RequestBody @Valid UsuarioDto usuarioDto) {
        UsuarioModel updatedProduct = usuarioService.updateUser(id, usuarioDto);
        if(updatedProduct == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") UUID id) {
        usuarioService.deleteUser(id);
        return ResponseEntity.status((HttpStatus.OK)).body("Product deleted successfully");
    }
}