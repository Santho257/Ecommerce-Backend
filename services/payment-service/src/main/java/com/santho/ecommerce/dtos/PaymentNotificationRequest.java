package com.santho.ecommerce.dtos;

import com.santho.ecommerce.models.PaymentMethod;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentNotificationRequest {
    private String id;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private int orderId;
    private String firstName;
    private String lastName;
    private String email;
}
