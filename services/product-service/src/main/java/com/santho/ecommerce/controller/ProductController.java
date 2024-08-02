package com.santho.ecommerce.controller;

import com.santho.ecommerce.dtos.product.ProductPurchaseRequestDto;
import com.santho.ecommerce.dtos.product.ProductPurchaseResponseDto;
import com.santho.ecommerce.dtos.product.ProductRequestDto;
import com.santho.ecommerce.dtos.product.ProductResponseDto;
import com.santho.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> findById(@PathVariable Integer id){
        return ResponseEntity.ok(productService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Integer> addProduct(@RequestBody @Valid ProductRequestDto request){
        return ResponseEntity.ok(productService.addProduct(request));
    }
    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponseDto>> purchaseProducts(@RequestBody @Valid List<ProductPurchaseRequestDto> purchaseRequest){
        return ResponseEntity.ok(productService.purchase(purchaseRequest));
    }

    @PutMapping("./{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Integer id, @RequestBody ProductRequestDto request){
        productService.update(id,request);
        return ResponseEntity.accepted().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return ResponseEntity.accepted().build();
    }
}
