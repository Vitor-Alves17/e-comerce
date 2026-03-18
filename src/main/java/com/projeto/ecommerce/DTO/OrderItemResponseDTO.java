package com.projeto.ecommerce.DTO;

import com.projeto.ecommerce.entities.OrderItemEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponseDTO {

    private double quantity;
    private double price;

    public OrderItemResponseDTO(OrderItemEntity orderItem) {
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
    }
}
