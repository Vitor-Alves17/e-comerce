package com.projeto.ecommerce.DTO;

import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.enums.StatusDoPedido;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class OrderResponseDTO {

    private LocalDate moment;
    private StatusDoPedido status;

    public OrderResponseDTO(OrderEntity order){
        this.moment = order.getMoment();
        this.status = order.getStatus();

    }

    @Override
    public String toString() {
        return "Order{" +
                "moment=" + moment +
                ", status=" + status +
                '}';
    }
}
