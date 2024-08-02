package com.santho.ecommerce.services;

import com.santho.ecommerce.dtos.OrderRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    ResponseEntity<Integer> createOrder(OrderRequestDto request);
}
