package com.santho.ecommerce.mappers;

import com.santho.ecommerce.dtos.OrderProductRequestDto;
import com.santho.ecommerce.models.Order;
import com.santho.ecommerce.models.OrderProduct;

public class OrderProductMapper {
    public static OrderProduct toOrderProduct(OrderProductRequestDto request){
        return OrderProduct.builder()
                .orderId(Order.builder()
                        .id(request.getOrderId())
                        .build())
                .productId(request.getProductId())
                .quantity(request.getQuantity())
                .build();
    }
}
