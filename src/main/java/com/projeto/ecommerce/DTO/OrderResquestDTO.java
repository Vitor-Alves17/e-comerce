package com.projeto.ecommerce.DTO;

import com.projeto.ecommerce.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResquestDTO {

    private LocalDate moment;
    private OrderStatus status;
}
