package com.projeto.ecommerce.services;

import com.projeto.ecommerce.DTO.OrderItemResponseDTO;
import com.projeto.ecommerce.DTO.OrderItemResquestDTO;
import com.projeto.ecommerce.entities.OrderEntity;
import com.projeto.ecommerce.entities.OrderItemEntity;
import com.projeto.ecommerce.entities.OrderItemPK;
import com.projeto.ecommerce.entities.ProductEntity;
import com.projeto.ecommerce.repositories.OrderItemRepository;
import com.projeto.ecommerce.repositories.OrderRepository;
import com.projeto.ecommerce.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    private final OrderItemRepository orderItemRepo;
    private final ProductRepository productRepo;
    private final OrderRepository orderRepo;


    public String newOrderItem(UUID product_id, UUID order_id, OrderItemResquestDTO dto){
        ProductEntity product = productRepo.findById(product_id).orElseThrow(() -> new RuntimeException("Product not found"));
        OrderEntity order = orderRepo.findById(order_id).orElseThrow(() -> new RuntimeException("Order not found"));
        OrderItemEntity orderItem = new OrderItemEntity(order, product ,dto);
        orderItemRepo.save(orderItem);
        return "Order Item Created Sucefully";
    }

    public OrderItemResponseDTO getOrderItemById(UUID product_id, UUID order_id){
        OrderItemPK pK = new OrderItemPK();
        ProductEntity product = productRepo.findById(product_id).orElseThrow(() -> new RuntimeException("Product not found"));
        OrderEntity order = orderRepo.findById(order_id).orElseThrow(() -> new RuntimeException("Order not found"));
        pK.setOrder(order);
        pK.setProduct(product);
        OrderItemEntity orderItem = orderItemRepo.findById(pK).orElseThrow(()->new RuntimeException("Não encontrado"));
        return new OrderItemResponseDTO(orderItem);
    }

    public String updateOrderItem(UUID product_id, UUID order_id,OrderItemResquestDTO dto){
        OrderItemPK pK = new OrderItemPK();
        ProductEntity product = productRepo.findById(product_id).orElseThrow(() -> new RuntimeException("Product not found"));
        OrderEntity order = orderRepo.findById(order_id).orElseThrow(() -> new RuntimeException("Order not found"));
        pK.setOrder(order);
        pK.setProduct(product);
        OrderItemEntity orderItem = orderItemRepo.findById(pK).orElseThrow(()->new RuntimeException("Não encontrado"));
        orderItem.setQuantity(dto.getQuantity());
        orderItem.setPrice(dto.getPrice());
        return "Updated sucefully";
    }

    public String removeOrderItemById(UUID product_id, UUID order_id){
        OrderItemPK pK = new OrderItemPK();
        ProductEntity product = productRepo.findById(product_id).orElseThrow(() -> new RuntimeException("Product not found"));
        OrderEntity order = orderRepo.findById(order_id).orElseThrow(() -> new RuntimeException("Order not found"));
        pK.setOrder(order);
        pK.setProduct(product);
        OrderItemEntity orderItem = orderItemRepo.findById(pK).orElseThrow(()->new RuntimeException("Não encontrado"));
        orderItemRepo.deleteById(pK);
        return "Deleted sucefully";
    }
}
