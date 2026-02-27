package com.projeto.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {
    @Id
    private UUID id;
    private LocalDate moment;


    @OneToOne
    //MapsId gera automaticamente o id correspondente à order
    @MapsId
    private OrderEntity order;
}
