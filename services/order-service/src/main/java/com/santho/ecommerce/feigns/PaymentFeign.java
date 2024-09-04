package com.santho.ecommerce.feigns;

import com.santho.ecommerce.dtos.PaymentRequestDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("PAYMENT-SERVICE/payments")
public interface PaymentFeign {
    @PostMapping
    ResponseEntity<Integer> create(@RequestBody @Valid PaymentRequestDto request);
}
