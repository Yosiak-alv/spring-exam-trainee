package com.digital.spring_exam_trainee.dto.requests;

import com.digital.spring_exam_trainee.common.validations.NotEmptyArray;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class OrderRequest {

    @NotNull
    @Positive
    private Long deliveryId;

    @NotNull
    @Positive
    private Long customerId;

    @NotNull
    @NotEmptyArray
    private Long[] productIds;
}
