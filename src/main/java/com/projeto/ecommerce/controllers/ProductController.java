package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTO.ProductRequestDTO;
import com.projeto.ecommerce.DTO.ProductResponseDTO;
import com.projeto.ecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/product")
    public ResponseEntity<?> newProduct(@Valid @RequestBody ProductRequestDTO dto){
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.newProduct(dto));
    }

    @GetMapping("producties")
    public List<ProductResponseDTO> getAll(){
        return service.getAll();
    }

    @PutMapping("product/update/{id}")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductRequestDTO dto, @PathVariable UUID id){
        return ResponseEntity.ok(service.updateProduct(dto, id));
    }

    @DeleteMapping("product/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable UUID id){
        return ResponseEntity.ok(service.deleteProductById(id));
    }
}
