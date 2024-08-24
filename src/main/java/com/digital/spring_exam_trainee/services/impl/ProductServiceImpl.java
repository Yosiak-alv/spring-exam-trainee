package com.digital.spring_exam_trainee.services.impl;


import com.digital.spring_exam_trainee.dto.CategoryDto;
import com.digital.spring_exam_trainee.dto.ProductDto;
import com.digital.spring_exam_trainee.dto.requests.ProductRequest;
import com.digital.spring_exam_trainee.exceptions.ResourceNotFoundException;
import com.digital.spring_exam_trainee.models.Order;
import com.digital.spring_exam_trainee.models.Product;
import com.digital.spring_exam_trainee.repositories.OrderRepository;
import com.digital.spring_exam_trainee.repositories.ProductRepository;
import com.digital.spring_exam_trainee.services.CategoryService;
import com.digital.spring_exam_trainee.services.OrderService;
import com.digital.spring_exam_trainee.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public List<ProductDto> findAll() {
        return this.repository.findAll().stream().map(ProductDto::new).toList();
    }

    @Override
    public ProductDto findById(Long id) {
        Product product = this.findModelById(id);
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
        Product product = this.findModelById(id);
        CategoryDto validate = categoryService.findById(productRequest.getCategoryId());
        if(validate != null && product != null){
            product.setName(productRequest.getName());
            product.setCategory(validate.toEntity());
            return new ProductDto(this.repository.save(product));
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Product product = this.findModelById(id);
        if(product != null){
            List<Order> orders = orderRepository.findAll();
            for (Order order : orders) {
                order.getProducts().remove(product);
            }
            this.repository.deleteById(product.getId());
        }
    }

    @Override
    public List<Product> findByIds(Long[] ids) {
        List<Product> products = new ArrayList<>();
        for (Long id : ids) {
            Product product = this.findModelById(id);
            products.add(product);
        }
        return products;
    }

    private Product findModelById(Long id) {
        return this.repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }
}
