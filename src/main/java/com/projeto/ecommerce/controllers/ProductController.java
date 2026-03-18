package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTO.ProductRequestDTO;
import com.projeto.ecommerce.DTO.ProductResponseDTO;
import com.projeto.ecommerce.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
