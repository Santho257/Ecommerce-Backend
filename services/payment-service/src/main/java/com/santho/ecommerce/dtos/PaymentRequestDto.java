package com.santho.ecommerce.dtos;

import com.santho.ecommerce.models.PaymentMethod;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Data
@Builder
@Validated
public class PaymentRequestDto {
    private String id;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private int orderId;
    private CustomerDto customer;
}
