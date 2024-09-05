package com.santho.ecommerce.dtos.order;

import com.santho.ecommerce.dtos.payment.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {
    private Integer id;
    private CustomerResponseDto customerResponseDto;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private List<PurchaseResponseDto> purchase;
    private OrderStatus orderStatus;
}
