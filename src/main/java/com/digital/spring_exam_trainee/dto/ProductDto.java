package com.digital.spring_exam_trainee.dto;

import com.digital.spring_exam_trainee.models.Product;
import lombok.Data;

@Data
public class ProductDto {
    private Long id;

    private String name;

    private CategoryDto category;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.category = new CategoryDto(product.getCategory());
    }

    public Product toEntity() {
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setCategory(this.category.toEntity());
        return product;
    }

}
