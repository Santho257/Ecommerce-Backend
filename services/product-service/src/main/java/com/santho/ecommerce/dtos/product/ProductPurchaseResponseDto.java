package com.santho.ecommerce.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPurchaseResponseDto {
    private Integer productId;
    private double quantity;
    private String productName;
    private String productDescription;
    private BigDecimal price;
}
