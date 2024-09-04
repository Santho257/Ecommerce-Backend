package com.santho.ecommerce.services;

import com.santho.ecommerce.dtos.OrderRequestDto;
import com.santho.ecommerce.dtos.OrderResponseDto;
import com.santho.ecommerce.dtos.OrderResponseGlobalDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Integer createOrder(OrderRequestDto request);

    List<OrderResponseGlobalDto> getOrders();

    OrderResponseGlobalDto getOrderById(Integer id);
}
