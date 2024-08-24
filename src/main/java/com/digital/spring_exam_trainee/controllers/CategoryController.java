package com.digital.spring_exam_trainee.controllers;

import com.digital.spring_exam_trainee.common.ApiResponse;
import com.digital.spring_exam_trainee.dto.requests.CategoryRequest;
import com.digital.spring_exam_trainee.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> index(){
        return ApiResponse.collectionResponse(this.categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        return ApiResponse.singleResponse(this.categoryService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> store(@Valid @RequestBody CategoryRequest categoryRequest){
        return ApiResponse.messageWithSingleResponse(
                "Category created successfully",
                this.categoryService.create(categoryRequest),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @Valid @RequestBody CategoryRequest categoryRequest){
        return ApiResponse.messageWithSingleResponse(
                "Category updated successfully",
                this.categoryService.update(id, categoryRequest),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id){
        this.categoryService.deleteById(id);
        return ApiResponse.messageResponse("Category deleted successfully", HttpStatus.OK);
    }
}
