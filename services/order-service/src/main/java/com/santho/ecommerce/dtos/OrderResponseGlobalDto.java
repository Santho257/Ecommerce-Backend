package com.santho.ecommerce.dtos;

import com.santho.ecommerce.models.OrderStatus;
import com.santho.ecommerce.models.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseGlobalDto {
    private Integer id;
    private String customerId;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private OrderStatus orderStatus;
}
