package com.santho.ecommerce.services;

import com.santho.ecommerce.dtos.OrderProductRequestDto;
import com.santho.ecommerce.dtos.PurchaseRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface OrderProductService {
    Integer add(OrderProductRequestDto op);
}
