package com.santho.ecommerce.controllers;

import com.santho.ecommerce.dtos.OrderRequestDto;
import com.santho.ecommerce.dtos.OrderResponseDto;
import com.santho.ecommerce.dtos.OrderResponseGlobalDto;
import com.santho.ecommerce.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Integer> createOrder(@RequestBody @Valid OrderRequestDto request){
        return ResponseEntity.status(201).body(orderService.createOrder(request));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseGlobalDto>> findAll(){
        return ResponseEntity.ok(orderService.getOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseGlobalDto> findById(@PathVariable Integer id){
        return ResponseEntity.ok(orderService.getOrderById(id) );
    }
}
