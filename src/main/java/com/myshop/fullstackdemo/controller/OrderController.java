package com.myshop.fullstackdemo.controller;

import com.myshop.fullstackdemo.model.Order;
import com.myshop.fullstackdemo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer/order")
public class OrderController {
    private final OrderRepository orderRepository;
    @GetMapping("/{customerId}")
    public ResponseEntity<List<Order>> getOrderBycustomerId(@PathVariable long customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        if (orders.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}