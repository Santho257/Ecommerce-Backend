package com.santho.ecommerce.services;

import com.santho.ecommerce.dtos.OrderProductRequestDto;
import com.santho.ecommerce.mappers.OrderProductMapper;
import com.santho.ecommerce.repositories.OrderProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProductServiceImpl implements OrderProductService{
    private final OrderProductRepository orderProductRepository;

    @Override
    public Integer add(OrderProductRequestDto op) {
        return orderProductRepository.save(OrderProductMapper.toOrderProduct(op)).getId();
    }
}
