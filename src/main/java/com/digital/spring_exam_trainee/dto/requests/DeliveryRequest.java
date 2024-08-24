package com.digital.spring_exam_trainee.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DeliveryRequest {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String status;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String type;
}
