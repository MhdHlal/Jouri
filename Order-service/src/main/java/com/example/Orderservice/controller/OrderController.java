package com.example.Orderservice.controller;

import com.example.Orderservice.models.Order;
import com.example.Orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    RestTemplate rest;

    private final OrderService orderService;


    @PostMapping
    public ResponseEntity<Object> addOrder(@RequestBody Order order){
        orderService.addOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }

    @CircuitBreaker(name = "CircuitBreakerService", fallbackMethod = "alter")
    @GetMapping("/{id}")
    public String getReceiptDetails(){
        return rest.getForObject("http://payment-service/api/payment/get",String.class);
    }


    public String alter(Exception e){
        return "Ooooops!";
    }
}
