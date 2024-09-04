package com.santho.ecommerce.services;

import com.santho.ecommerce.dtos.OrderProductRequestDto;
import com.santho.ecommerce.dtos.OrderProductResponseDto;
import com.santho.ecommerce.dtos.PurchaseRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderProductService {
    Integer add(OrderProductRequestDto op);

    List<OrderProductResponseDto> findByOrderId(int orderId);
}
