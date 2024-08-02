package com.santho.ecommerce.controllers;

import com.santho.ecommerce.dtos.CustomerRequestDto;
import com.santho.ecommerce.dtos.CustomerResponseDto;
import com.santho.ecommerce.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> findById(@PathVariable String id){
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody @Valid CustomerRequestDto request){
        return ResponseEntity.ok(customerService.add(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id,@RequestBody CustomerRequestDto request){
        customerService.update(id, request);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        customerService.delete(id);
        return ResponseEntity.accepted().build();
    }
}
