package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTO.ProductRequestDTO;
import com.projeto.ecommerce.DTO.ProductResponseDTO;
import com.projeto.ecommerce.entities.ProductEntity;
import com.projeto.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepo;

    public ProductService(ProductRepository productRepos) {
        this.productRepo = productRepos;
    }

    public List<ProductResponseDTO> getAll(){
        List<ProductEntity> producties = productRepo.findAll();
        return producties.stream().map(ProductResponseDTO::new).toList();
    }

    public String newProduct(ProductRequestDTO dto){
        ProductEntity product = new ProductEntity(dto);
        productRepo.save(product);
        return "Product created sucefully";
    }
}
