package com.santho.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EmailTemplates {
    ORDER_EMAIL("order.html", "Details of your payment - reg"),
    PAYMENT_EMAIL("payment.html", "Details of your payment - reg");

    private final String template;
    private final String subject;
}
