package com.santho.ecommerce.mappers;

import com.santho.ecommerce.dtos.product.ProductPurchaseResponseDto;
import com.santho.ecommerce.dtos.product.ProductRequestDto;
import com.santho.ecommerce.dtos.product.ProductResponseDto;
import com.santho.ecommerce.models.Category;
import com.santho.ecommerce.models.Product;

public class ProductMapper {
    public static ProductResponseDto toProductResponse(Product product){
        return ProductResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .availableQuantity(product.getAvailableQuantity())
                .price(product.getPrice())
                .categoryId(product.getCategoryId().getId())
                .category(product.getCategoryId().getName())
                .build();
    }

    public static ProductPurchaseResponseDto toPurchaseResponse(Product product, double quantity){
        return ProductPurchaseResponseDto.builder()
                .price(product.getPrice())
                .productId(product.getId())
                .productName(product.getName())
                .productDescription(product.getDescription())
                .quantity(quantity)
                .build();
    }

    public static Product toProduct(ProductRequestDto request){
        return Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .availableQuantity(request.getAdditionalQuantity())
                .price(request.getPrice())
                .categoryId(Category.builder().id(request.getCategoryId()).build())
                .build();
    }
}
