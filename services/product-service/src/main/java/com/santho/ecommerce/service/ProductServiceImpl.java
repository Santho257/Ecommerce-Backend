package com.santho.ecommerce.service;

import com.santho.ecommerce.dtos.product.ProductPurchaseRequestDto;
import com.santho.ecommerce.dtos.product.ProductPurchaseResponseDto;
import com.santho.ecommerce.dtos.product.ProductRequestDto;
import com.santho.ecommerce.dtos.product.ProductResponseDto;
import com.santho.ecommerce.exceptions.InsufficientQuantityException;
import com.santho.ecommerce.mappers.ProductMapper;
import com.santho.ecommerce.models.Category;
import com.santho.ecommerce.models.Product;
import com.santho.ecommerce.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    @Override
    public List<ProductResponseDto> findAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper::toProductResponse)
                .toList();
    }

    @Override
    public ProductResponseDto findById(Integer id) {
        return productRepository.findById(id)
                .map(ProductMapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product Not available with id: " + id));
    }

    @Override
    public Integer addProduct(ProductRequestDto request) {
        return productRepository.save(ProductMapper.toProduct(request)).getId();
    }

    @Override
    public void update(Integer id, ProductRequestDto request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product Not available with id: " + id));
        merge(product, request);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        if(!productRepository.existsById(id))
            throw new EntityNotFoundException("Product Not available with id : " + id);
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductPurchaseResponseDto> purchase(List<ProductPurchaseRequestDto> purchaseRequest) {
        List<Product> products = productRepository.findAllById(
                purchaseRequest.stream()
                        .map(ProductPurchaseRequestDto::getProductId)
                        .toList()
        );
        if(products.size() != purchaseRequest.size())
            throw new EntityNotFoundException("One or More products doesnot exists");
        List<ProductPurchaseResponseDto> response = new ArrayList<>(products.size());
        for(int i = 0; i < products.size(); i++){
            Product prod = products.get(i);
            ProductPurchaseRequestDto req = purchaseRequest.get(i);
            if(req.getQuantity() > prod.getAvailableQuantity())
                throw new InsufficientQuantityException("Insufficient quantity for product with id : " + prod.getId());
            prod.setAvailableQuantity(prod.getAvailableQuantity() - req.getQuantity());
            response.add(ProductMapper.toPurchaseResponse(prod, req.getQuantity()));
        }
        productRepository.saveAll(products);
        return response;
    }


    private void merge(Product product, ProductRequestDto request){
        if(StringUtils.isNotBlank(request.getName()))
            product.setName(request.getName());
        if(StringUtils.isNotBlank(request.getDescription()))
            product.setDescription(request.getDescription());
        if(!request.getPrice().equals(BigDecimal.valueOf(0)))
            product.setPrice(request.getPrice());
        if(request.getAdditionalQuantity() != 0)
            product.setAvailableQuantity(product.getAvailableQuantity() + request.getAdditionalQuantity());
        if(request.getCategoryId() != null && categoryService.exists(request.getCategoryId()))
            product.setCategoryId(Category.builder()
                    .id(request.getCategoryId()).build());
    }
}
