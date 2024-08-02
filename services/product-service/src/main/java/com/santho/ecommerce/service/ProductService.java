package com.santho.ecommerce.service;

import com.santho.ecommerce.dtos.product.ProductPurchaseRequestDto;
import com.santho.ecommerce.dtos.product.ProductPurchaseResponseDto;
import com.santho.ecommerce.dtos.product.ProductRequestDto;
import com.santho.ecommerce.dtos.product.ProductResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductResponseDto> findAll();

    ProductResponseDto findById(Integer id);

    Integer addProduct(ProductRequestDto request);

    void update(Integer id, ProductRequestDto request);

    void deleteProduct(Integer id);

    List<ProductPurchaseResponseDto> purchase(List<ProductPurchaseRequestDto> purchaseRequest);
}
