package com.santho.ecommerce.mappers;

import com.santho.ecommerce.dtos.OrderRequestDto;
import com.santho.ecommerce.models.Order;

public class OrderMapper {
    public static Order toOrder(OrderRequestDto request){
        return Order.builder()
                .customerId(request.getCustomerId())
                .paymentMethod(request.getPaymentMethod())
                .amount(request.getAmount())
                .build();
    }
}
