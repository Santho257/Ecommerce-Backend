package com.santho.ecommerce.mappers;

import com.santho.ecommerce.dtos.category.CategoryRequestDto;
import com.santho.ecommerce.dtos.category.CategoryResponseDto;
import com.santho.ecommerce.models.Category;

public class CategoryMapper {
    public static CategoryResponseDto toCategoryResponse(Category category){
        return CategoryResponseDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

    public static Category toCategory(CategoryRequestDto request){
        return Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
    }

}
