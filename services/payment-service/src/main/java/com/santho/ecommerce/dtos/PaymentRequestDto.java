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
        @Min(value = 1,message = "Minimum amount should be 1")
        private BigDecimal amount;
        @NotNull
        private PaymentMethod paymentMethod;
        @NotNull(message = "Order Id Cannot be Empty")
        private int orderId;
        private CustomerDto customer;
}
