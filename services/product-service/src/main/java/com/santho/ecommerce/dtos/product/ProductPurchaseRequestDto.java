package com.santho.ecommerce.dtos.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class ProductPurchaseRequestDto {
    @NotNull(message = "Product id is required")
    private Integer productId;
    @NotNull(message = "Quantity is required")
    @Min( value = 1, message = "Quantity should be greater than 0")
    private double quantity;

}
