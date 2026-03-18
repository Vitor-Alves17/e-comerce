package com.projeto.ecommerce.entities;


import com.projeto.ecommerce.DTO.OrderItemResponseDTO;
import com.projeto.ecommerce.DTO.OrderItemResquestDTO;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemEntity {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private double quantity;
    private double price;

    public OrderItemEntity(OrderEntity order, ProductEntity product, double quantity, double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItemEntity(OrderEntity order, ProductEntity product, OrderItemResquestDTO dto) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = dto.getQuantity();
        this.price = dto.getPrice();
    }

    public OrderEntity getOrder(){
        return id.getOrder();
    }

    public void setOrder(OrderEntity order){
        id.setOrder(order);
    }

    public ProductEntity getProduct(){
        return id.getProduct();
    }

    public void setProduct(ProductEntity product){
        id.setProduct(product);
    }
}
