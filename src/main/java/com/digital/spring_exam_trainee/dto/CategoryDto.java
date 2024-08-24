package com.digital.spring_exam_trainee.dto;

import com.digital.spring_exam_trainee.enums.CategoryType;
import com.digital.spring_exam_trainee.models.Category;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class CategoryDto {
    private Long id;
    private String name;
    private String type;

    public CategoryDto(Category category){
        BeanUtils.copyProperties(category, this);
    }

    public Category toEntity(){
        Category category = new Category();
        BeanUtils.copyProperties(this, category);
        return category;
    }
}
