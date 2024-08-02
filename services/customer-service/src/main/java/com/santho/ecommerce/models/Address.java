package com.santho.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Address {
    private String doorNo;
    private String street;
    private String city;
    private String zipCode;
}
