package com.santho.ecommerce.feigns;

import com.santho.ecommerce.dtos.PurchaseRequestDto;
import com.santho.ecommerce.dtos.PurchaseResponseDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("PRODUCT-SERVICE/products")
public interface ProductFeign {
    @PostMapping("/purchase")
    ResponseEntity<List<PurchaseResponseDto>> purchaseProducts(@RequestBody @Valid List<PurchaseRequestDto> purchaseRequest);
}
