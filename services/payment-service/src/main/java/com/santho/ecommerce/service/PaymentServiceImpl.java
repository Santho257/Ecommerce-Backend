package com.santho.ecommerce.service;

import com.santho.ecommerce.dtos.PaymentRequestDto;
import com.santho.ecommerce.mappers.PaymentMapper;
import com.santho.ecommerce.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;
    @Override
    public Integer createPayment(PaymentRequestDto request) {
        paymentRepository.save(PaymentMapper.toPayment(request));
        return 0;
    }
}
