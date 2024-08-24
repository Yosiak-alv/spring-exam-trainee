package com.digital.spring_exam_trainee.services.impl;

import ch.qos.logback.core.net.server.Client;
import com.digital.spring_exam_trainee.dto.CategoryDto;
import com.digital.spring_exam_trainee.dto.requests.CategoryRequest;
import com.digital.spring_exam_trainee.exceptions.ResourceNotFoundException;
import com.digital.spring_exam_trainee.models.Category;
import com.digital.spring_exam_trainee.repositories.CategoryRepository;
import com.digital.spring_exam_trainee.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Override
    public List<CategoryDto> findAll() {
        return this.repository.findAll().stream().map(CategoryDto::new).toList();
    }

    @Override
    public CategoryDto findById(Long id) {
        Category category = this.repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        return new CategoryDto(category);
    }

    @Override
    public CategoryDto create(CategoryRequest categoryRequest) {
        Category newCategory = new Category();
        newCategory.setName(categoryRequest.getName());
        newCategory.setType(categoryRequest.getType());
        return new CategoryDto(this.repository.save(newCategory));
    }

    @Override
    public CategoryDto update(Long id, CategoryRequest categoryRequest) {
        CategoryDto categoryDto = this.findById(id);
        Category category = categoryDto.toEntity();
        category.setName(categoryRequest.getName());
        category.setType(categoryRequest.getType());
        return new CategoryDto(this.repository.save(category));
    }

    @Override
    public void deleteById(Long id) {
        CategoryDto categoryDto = this.findById(id);
        this.repository.deleteById(categoryDto.getId());
    }
}
