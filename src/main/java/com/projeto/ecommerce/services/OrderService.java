package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTO.OrderResquestDTO;
import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.repositories.OrderRepository;
import com.projeto.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }




    public String createOrder(OrderResquestDTO dto, UUID id) {
        UserEntity user = userRepository.getReferenceById(id);
        OrderEntity order = new OrderEntity(dto);
        order.setClient(user);
        orderRepository.save(order);
        return "Order saved sucefully";
    }
}