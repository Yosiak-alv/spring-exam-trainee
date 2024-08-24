package com.digital.spring_exam_trainee.dto.requests;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CustomerRequest {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 100)
    private String address;

}
