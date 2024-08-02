package com.santho.ecommerce.dtos;

import com.santho.ecommerce.models.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.PayloadApplicationEvent;

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
}
