package com.example.Orderservice.service;

import com.example.Orderservice.models.Order;
import com.example.Orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void addOrder(Order order){
        orderRepository.insert(order);
    }

    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }
}
