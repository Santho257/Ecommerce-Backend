package com.santho.ecommerce.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Builder
@Validated
public class CustomerDto {
    private String id;
    @NotBlank(message = "Firstname is Required")
    private String firstName;
    @NotBlank(message = "LastName is Required")
    private String lastName;
    @NotBlank(message = "Email is Required")
    @Email(message = "Email Should be formatted correctly")
    private String email;
}
