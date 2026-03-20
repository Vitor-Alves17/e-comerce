package com.projeto.ecommerce.DTO;

import com.projeto.ecommerce.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {

    private UUID id;
    private String name;
    private String description;
    private double price;
    private String imgURL;

    public ProductResponseDTO(ProductEntity product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.imgURL = product.getImgURL();
    }
}
