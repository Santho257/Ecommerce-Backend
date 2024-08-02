package com.santho.ecommerce.controller;

import com.santho.ecommerce.dtos.category.CategoryRequestDto;
import com.santho.ecommerce.dtos.category.CategoryResponseDto;
import com.santho.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> findById(@PathVariable int id){
        return ResponseEntity.ok(categoryService.findById(id));
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> exists(@PathVariable int id){
        return ResponseEntity.ok(categoryService.exists(id));
    }
    @PostMapping
    public ResponseEntity<Integer> addCategory(@RequestBody @Valid CategoryRequestDto request){
        return ResponseEntity.ok(categoryService.addCategory(request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id){
        categoryService.delete(id);
        return ResponseEntity.accepted().build();
    }
}
