package com.santho.ecommerce.exceptions;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class OrderException extends RuntimeException{
    private final String message;
}
