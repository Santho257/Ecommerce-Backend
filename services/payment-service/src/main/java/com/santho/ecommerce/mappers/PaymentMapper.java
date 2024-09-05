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

    public static PaymentNotificationRequest toNotification(Payment payment,PaymentRequestDto requestDto){
        return PaymentNotificationRequest.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .email(requestDto.getCustomer().getEmail())
                .firstName(requestDto.getCustomer().getFirstName())
                .lastName(requestDto.getCustomer().getLastName())
                .orderId(payment.getOrderId())
                .paymentMethod(payment.getPaymentMethod())
                .build();
    }
}
