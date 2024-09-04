package com.santho.ecommerce.services;

import com.santho.ecommerce.dtos.OrderProductRequestDto;
import com.santho.ecommerce.dtos.OrderProductResponseDto;
import com.santho.ecommerce.mappers.OrderProductMapper;
import com.santho.ecommerce.repositories.OrderProductRepository;
import com.santho.ecommerce.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderProductServiceImpl implements OrderProductService {
    private final OrderProductRepository orderProductRepository;
    private final OrderRepository orderRepository;

    @Override
    public Integer add(OrderProductRequestDto op) {
        return orderProductRepository.save(OrderProductMapper.toOrderProduct(op)).getId();
    }

    @Override
    public List<OrderProductResponseDto> findByOrderId(int orderId) {
        return orderProductRepository
                .findByOrderId(orderRepository
                        .findById(orderId)
                        .orElseThrow(() -> new EntityNotFoundException("No orders found with Id :: " + orderId)))
                .stream()
                .map(OrderProductMapper::toOrderProductResponse)
                .toList();
    }
}
