package com.santho.ecommerce.mappers;

import com.santho.ecommerce.dtos.*;
import com.santho.ecommerce.models.Order;
import com.santho.ecommerce.models.OrderStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class OrderMapper {
    public static Order toOrder(OrderRequestDto request){
        return Order.builder()
                .customerId(request.getCustomerId())
                .paymentMethod(request.getPaymentMethod())
                .status(OrderStatus.ORDERED)
                .amount(request.getAmount())
                .build();
    }

    public static OrderResponseDto toOrderResponse(Order order, CustomerResponseDto customer, List<PurchaseResponseDto> purchaseResponse) {
        return OrderResponseDto
                .builder()
                .id(order.getId())
                .customerResponseDto(customer)
                .paymentMethod(order.getPaymentMethod())
                .purchase(purchaseResponse)
                .totalAmount(order.getAmount())
                .build();
    }

    public static OrderResponseGlobalDto toGlobalOrderResponse(Order order) {
        return OrderResponseGlobalDto.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .paymentMethod(order.getPaymentMethod())
                .totalAmount(order.getAmount())
                .orderStatus(order.getStatus())
                .build();
    }
}
