package com.santho.ecommerce.dtos;

import com.santho.ecommerce.models.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class OrderRequestDto {
    @NotBlank(message = "username is required")
    private String customerId;
    @Positive(message = "amount should be greater than or equal to zero")
    private BigDecimal amount;
    @NotNull(message = "Choose a valid payment method")
    private PaymentMethod paymentMethod;
    @NotEmpty(message = "Should choose at-least a product to process an order")
    private List<PurchaseRequestDto> products;
}
