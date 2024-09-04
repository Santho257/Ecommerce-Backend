package com.santho.ecommerce.mappers;

import com.santho.ecommerce.dtos.PaymentRequestDto;
import com.santho.ecommerce.models.Payment;

public class PaymentMapper {
    public static Payment toPayment(PaymentRequestDto request){
        return Payment.builder()
                .orderId(request.getOrderId())
                .paymentMethod(request.getPaymentMethod())
                .amount(request.getAmount())
                .build();
    }
}
