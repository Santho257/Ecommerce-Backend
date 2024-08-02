package com.santho.ecommerce.service;

import com.santho.ecommerce.dtos.category.CategoryRequestDto;
import com.santho.ecommerce.dtos.category.CategoryResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<CategoryResponseDto> findAll();

    CategoryResponseDto findById(int id);

    Integer addCategory(CategoryRequestDto request);

    void delete(int id);

    Boolean exists(int id);
}
