package com.santho.ecommerce.controller;

import com.santho.ecommerce.dtos.PaymentRequestDto;
import com.santho.ecommerce.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping()
    public ResponseEntity<Integer> create(@RequestBody @Valid PaymentRequestDto request){
        return ResponseEntity.ok(paymentService.createPayment(request));
    }
}
