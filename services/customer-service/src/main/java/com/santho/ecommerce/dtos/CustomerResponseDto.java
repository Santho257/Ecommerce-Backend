package com.santho.ecommerce.dtos;

import com.santho.ecommerce.models.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponseDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
}
