package com.santho.ecommerce.service;

import com.santho.ecommerce.dtos.PaymentRequestDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    Integer createPayment(@Valid PaymentRequestDto request);
}
