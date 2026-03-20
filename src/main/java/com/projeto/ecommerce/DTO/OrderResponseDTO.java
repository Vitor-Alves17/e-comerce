package com.projeto.ecommerce.DTO;

import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.enums.OrderStatus;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class OrderResponseDTO {

    private UUID id;
    private LocalDate moment;
    private OrderStatus status;
    private UserResponseDTO user;

    public OrderResponseDTO(OrderEntity order, UserResponseDTO user){
        this.id = order.getId();
        this.moment = order.getMoment();
        this.status = order.getStatus();
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "moment=" + moment +
                ", status=" + status +
                '}';
    }
}
