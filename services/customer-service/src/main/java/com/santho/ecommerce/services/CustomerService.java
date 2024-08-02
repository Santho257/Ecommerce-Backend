package com.santho.ecommerce.services;

import com.santho.ecommerce.dtos.CustomerRequestDto;
import com.santho.ecommerce.dtos.CustomerResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<CustomerResponseDto> findAll();

    String add(CustomerRequestDto request);

    void update(String id, CustomerRequestDto request);

    void delete(String id);

    CustomerResponseDto findById(String id);
}
