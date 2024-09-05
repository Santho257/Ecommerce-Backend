package com.santho.ecommerce.dtos;

import com.santho.ecommerce.models.PaymentMethod;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Data
@Builder
@Validated
public class PaymentRequestDto {
        private BigDecimal amount;
        private PaymentMethod paymentMethod;
        private int orderId;
        private CustomerDto customer;
}
