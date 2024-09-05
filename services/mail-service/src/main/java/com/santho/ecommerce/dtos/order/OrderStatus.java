package com.santho.ecommerce.dtos.order;

public enum OrderStatus {
    ORDERED,
    PAYMENT_FAILED,
    SHIPPED,
    OUT_FOR_DELIVERY,
    DELIVERED,
    CANCELED
}
