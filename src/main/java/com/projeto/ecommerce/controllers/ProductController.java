package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTO.ProductRequestDTO;
import com.projeto.ecommerce.DTO.ProductResponseDTO;
import com.projeto.ecommerce.repositories.ProductRepository;
import com.projeto.ecommerce.services.ProductPhotoService;
import com.projeto.ecommerce.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;
    private final ProductPhotoService photoService;

    @PostMapping("/product")
    public ResponseEntity<?> newProduct(@Valid @RequestBody ProductRequestDTO dto, @RequestParam MultipartFile file) throws IOException {
        return  ResponseEntity.status(HttpStatus.CREATED).body(service.newProduct(dto, photoService.uploadPhoto(file)));
    }

    @GetMapping("producties")
    public List<ProductResponseDTO> getAll(){
        return service.getAll();
    }

    @PutMapping("product/update/{id}")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductRequestDTO dto, @PathVariable UUID id, @RequestParam MultipartFile file) throws IOException {
        return ResponseEntity.ok(service.updateProduct(dto, id, photoService.uploadPhoto(file)));
    }

    @DeleteMapping("product/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable UUID id){
        return ResponseEntity.ok(service.deleteProductById(id));
    }
}
