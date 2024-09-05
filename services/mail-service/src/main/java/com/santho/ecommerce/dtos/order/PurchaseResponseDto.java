package com.santho.ecommerce.dtos.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseResponseDto {
    private Integer productId;
    private double quantity;
    private String productName;
    private String productDescription;
    private BigDecimal price;
}
