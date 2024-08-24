package com.digital.spring_exam_trainee.services;

import com.digital.spring_exam_trainee.dto.CategoryDto;
import com.digital.spring_exam_trainee.dto.requests.CategoryRequest;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();

    CategoryDto findById(Long id);

    CategoryDto create(CategoryRequest categoryRequest);

    CategoryDto update(Long id, CategoryRequest categoryRequest);

    void deleteById(Long id);
}
