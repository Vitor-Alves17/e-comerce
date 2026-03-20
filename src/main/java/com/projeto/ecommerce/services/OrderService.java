package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTO.OrderResponseDTO;
import com.projeto.ecommerce.DTO.OrderResquestDTO;
import com.projeto.ecommerce.DTO.ProductRequestDTO;
import com.projeto.ecommerce.DTO.UserResponseDTO;
import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.entities.ProductEntity;
import com.projeto.ecommerce.entities.UserEntity;
import com.projeto.ecommerce.repositories.OrderRepository;
import com.projeto.ecommerce.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public String createOrder(UUID id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not Found"));
        OrderEntity order = new OrderEntity();
        order.setClient(user);
        orderRepository.save(order);
        return "Order saved sucefully";
    }

    public List<OrderResponseDTO> showAll(){
        List<OrderEntity> orders = orderRepository.findAll();
        return orders.stream().map(order -> new OrderResponseDTO(order, new UserResponseDTO(order.getClient()))).toList();
    }

    public String updateOrder(OrderResquestDTO dto, UUID id){
        OrderEntity order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(dto.getStatus());
        orderRepository.save(order);
        return "Updated sucefully";
    }

    public String deleteOrderById(UUID id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return "Order deleted sucefully";
        } else {
            return "Order not found";
        }
    }
}