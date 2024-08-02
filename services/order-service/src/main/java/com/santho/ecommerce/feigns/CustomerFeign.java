package com.santho.ecommerce.feigns;

import com.santho.ecommerce.dtos.CustomerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CUSTOMER-SERVICE/customers")
public interface CustomerFeign {
    @GetMapping("/{id}")
    ResponseEntity<CustomerResponseDto> findById(@PathVariable String id);
}
