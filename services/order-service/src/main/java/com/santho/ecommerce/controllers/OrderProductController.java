package com.santho.ecommerce.controllers;

import com.santho.ecommerce.dtos.OrderProductResponseDto;
import com.santho.ecommerce.services.OrderProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order-products")
@RequiredArgsConstructor
public class OrderProductController {
    private final OrderProductService service;

    @GetMapping("/order/{order-id}")
    private ResponseEntity<List<OrderProductResponseDto>> findByOrder(@PathVariable("order-id") int orderId){
        return ResponseEntity.ok(service.findByOrderId(orderId));
    }
}
