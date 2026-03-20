package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTO.OrderResponseDTO;
import com.projeto.ecommerce.DTO.OrderResquestDTO;
import com.projeto.ecommerce.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/order/{id}")
    public ResponseEntity<?> create(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createOrder(id));
    }

    @GetMapping("/order/show")
    public List<OrderResponseDTO> showAll(){
        return service.showAll();
    }

    @PutMapping("/order/update/{id}")
    public ResponseEntity<?> updateOrder(@Valid @RequestBody OrderResquestDTO dto, @PathVariable UUID id){
        return ResponseEntity.ok(service.updateOrder(dto, id));
    }

    @DeleteMapping("/order/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.deleteOrderById(id));
    }
}
