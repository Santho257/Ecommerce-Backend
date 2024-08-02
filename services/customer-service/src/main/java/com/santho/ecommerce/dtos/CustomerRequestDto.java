package com.santho.ecommerce.dtos;

import com.santho.ecommerce.models.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class CustomerRequestDto {
    @NotBlank(message = "Firstname is Required")
    private String firstName;
    @NotBlank(message = "LastName is Required")
    private String lastName;
    @NotBlank(message = "Email is Required")
    @Email(message = "Email Should be valid")
    private String email;
    @NotNull(message = "Address is Required")
    private Address address;
}
