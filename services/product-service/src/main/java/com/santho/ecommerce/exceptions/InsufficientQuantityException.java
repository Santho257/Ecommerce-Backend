package com.santho.ecommerce.exceptions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class InsufficientQuantityException extends RuntimeException{
    private String message;
}
