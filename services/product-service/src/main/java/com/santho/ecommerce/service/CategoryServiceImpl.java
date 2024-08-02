package com.santho.ecommerce.service;

import com.santho.ecommerce.dtos.category.CategoryRequestDto;
import com.santho.ecommerce.dtos.category.CategoryResponseDto;
import com.santho.ecommerce.mappers.CategoryMapper;
import com.santho.ecommerce.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponseDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();
    }

    @Override
    public CategoryResponseDto findById(int id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper::toCategoryResponse)
                .orElseThrow(() -> new EntityNotFoundException("Category With Id : "+id+ " Not found"));
    }

    @Override
    public Integer addCategory(CategoryRequestDto request) {
        return categoryRepository.save(CategoryMapper.toCategory(request)).getId();
    }


    @Override
    public void delete(int id) {
        if(!exists(id))
            throw new EntityNotFoundException("Category With id : "+id+" not found");
        categoryRepository.deleteById(id);
    }

    @Override
    public Boolean exists(int id) {
        return categoryRepository.existsById(id);
    }
}
