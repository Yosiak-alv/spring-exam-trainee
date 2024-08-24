package com.digital.spring_exam_trainee.services;

import com.digital.spring_exam_trainee.dto.ProductDto;
import com.digital.spring_exam_trainee.dto.requests.ProductRequest;
import com.digital.spring_exam_trainee.models.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findById(Long id);
    ProductDto create(ProductRequest productRequest);
    ProductDto update(Long id, ProductRequest productRequest);
    void deleteById(Long id);

    List<Product> findByIds(Long[] productIds);
}
