package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTO.OrderResquestDTO;
import com.projeto.ecommerce.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/post/{id}")
    public ResponseEntity<?> create(@Valid @RequestBody OrderResquestDTO req, @PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createOrder(req, id));
    }
}
