package com.digital.spring_exam_trainee.services.impl;


import com.digital.spring_exam_trainee.dto.CategoryDto;
import com.digital.spring_exam_trainee.dto.CustomerDto;
import com.digital.spring_exam_trainee.dto.ProductDto;
import com.digital.spring_exam_trainee.dto.requests.ProductRequest;
import com.digital.spring_exam_trainee.exceptions.ResourceNotFoundException;
import com.digital.spring_exam_trainee.models.Customer;
import com.digital.spring_exam_trainee.models.Product;
import com.digital.spring_exam_trainee.repositories.ProductRepository;
import com.digital.spring_exam_trainee.services.CategoryService;
import com.digital.spring_exam_trainee.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    //TODO when updating a product if this is in a order, delete the association with the order, so the order will not have this product anymore
    //TODO fix this
    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public List<ProductDto> findAll() {
        return this.repository.findAll().stream().map(ProductDto::new).toList();
    }

    @Override
    public ProductDto findById(Long id) {
        Product product = this.repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        return new ProductDto(product);
    }

    @Override
    public ProductDto create(ProductRequest productRequest) {
        //validate category
        CategoryDto validate = categoryService.findById(productRequest.getCategoryId());
        if(validate != null){
            Product newProduct = new Product();
            newProduct.setName(productRequest.getName());
            newProduct.setCategory(validate.toEntity());
            return new ProductDto(this.repository.save(newProduct));
        }
        return null;
    }

    @Override
    public ProductDto update(Long id, ProductRequest productRequest) {
        ProductDto productDto = this.findById(id);
        CategoryDto validate = categoryService.findById(productRequest.getCategoryId());
        if(validate != null){
            Product product = productDto.toEntity();
            product.setName(productRequest.getName());
            product.setCategory(validate.toEntity());
            return new ProductDto(this.repository.save(product));
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        ProductDto productDto = this.findById(id);
        this.repository.deleteById(productDto.getId());
    }

    public List<Product> findByIds(Long[] ids) {
        List<Product> products = new ArrayList<>();
        for (Long id : ids) {
            Product product = this.repository
                    .findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
            products.add(product);
        }
        return products;
    }
}
