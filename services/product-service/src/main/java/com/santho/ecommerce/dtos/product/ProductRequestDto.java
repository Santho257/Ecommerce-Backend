package com.santho.ecommerce.dtos.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class ProductRequestDto {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "description is required")
    private String description;
    @Positive(message = "Quanity shouldn't be negative")
    private double additionalQuantity;
    @Positive(message = "Price shouldn't be negative")
    private BigDecimal price;
    @NotNull(message = "CategoryId is required")
    private Integer categoryId;
}
