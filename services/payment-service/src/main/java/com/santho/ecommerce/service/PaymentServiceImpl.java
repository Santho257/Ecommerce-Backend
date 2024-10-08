package com.santho.ecommerce.service;

import com.santho.ecommerce.dtos.PaymentRequestDto;
import com.santho.ecommerce.kafka.NotificationProducer;
import com.santho.ecommerce.mappers.PaymentMapper;
import com.santho.ecommerce.models.Payment;
import com.santho.ecommerce.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;
    private final NotificationProducer notificationProducer;

    @Override
    public Integer createPayment(PaymentRequestDto request) {
        Payment payment = paymentRepository.save(PaymentMapper.toPayment(request));
        notificationProducer.sendNotification(PaymentMapper.toNotification(payment, request));
        return 0;
    }
}
