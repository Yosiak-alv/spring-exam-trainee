package com.digital.spring_exam_trainee.dto.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductRequest {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @Positive
    private Long categoryId;
}
