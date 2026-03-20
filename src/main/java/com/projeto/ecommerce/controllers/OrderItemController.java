package com.projeto.ecommerce.controllers;

import com.projeto.ecommerce.DTO.OrderItemResponseDTO;
import com.projeto.ecommerce.DTO.OrderItemResquestDTO;
import com.projeto.ecommerce.entities.OrderItemEntity;
import com.projeto.ecommerce.services.OrderItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class OrderItemController {

    private final OrderItemService service;

    public OrderItemController(OrderItemService service) {
        this.service = service;
    }

    @GetMapping("/order/{order_id}/product/{product_id}")
    public OrderItemResponseDTO getById(@PathVariable UUID order_id, @PathVariable UUID product_id){
        return service.getOrderItemById(order_id, product_id);
    }

    @PostMapping("/order/{order_id}/product/{product_id}")
    public ResponseEntity<?> newOrderItem(@PathVariable UUID product_id, @PathVariable UUID order_id, @Valid @RequestBody OrderItemResquestDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.newOrderItem(product_id, order_id, dto));
    }

    @PutMapping("/order/{order_id}/product/{product_id}")
    public ResponseEntity<?> updateOrderItem(@PathVariable UUID product_id, @PathVariable UUID order_id, @Valid @RequestBody OrderItemResquestDTO dto){
        return ResponseEntity.ok(service.updateOrderItem(product_id, order_id, dto));
    }

    @DeleteMapping("/order/{order_id}/product/{product_id}")
    public ResponseEntity<?> deleteOrderItem(@PathVariable UUID product_id, @PathVariable UUID order_id){
        return ResponseEntity.ok(service.removeOrderItemById(product_id, order_id));
    }
}
