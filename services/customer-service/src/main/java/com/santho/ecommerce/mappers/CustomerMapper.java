package com.santho.ecommerce.mappers;

import com.santho.ecommerce.dtos.CustomerRequestDto;
import com.santho.ecommerce.dtos.CustomerResponseDto;
import com.santho.ecommerce.models.Customer;

public class CustomerMapper {
    public static Customer toCustomer(CustomerRequestDto customerRequestDto){
        return Customer.builder()
                .email(customerRequestDto.getEmail())
                .firstName(customerRequestDto.getFirstName())
                .lastName(customerRequestDto.getLastName())
                .address(customerRequestDto.getAddress())
                .build();
    }

    public static CustomerResponseDto toCustomerResponse(Customer customer) {
        return CustomerResponseDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .build();
    }
}
