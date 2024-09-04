package com.santho.ecommerce.mappers;

import com.santho.ecommerce.dtos.PaymentNotificationRequest;
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

    public static PaymentNotificationRequest toNotification(PaymentRequestDto requestDto){
        return PaymentNotificationRequest.builder()
                .id(requestDto.getId())
                .amount(requestDto.getAmount())
                .email(requestDto.getCustomer().getEmail())
                .firstName(requestDto.getCustomer().getFirstName())
                .lastName(requestDto.getCustomer().getLastName())
                .orderId(requestDto.getOrderId())
                .paymentMethod(requestDto.getPaymentMethod())
                .build();
    }
}
