package com.digital.spring_exam_trainee.dto.requests;

import com.digital.spring_exam_trainee.common.validations.NotEmptyArray;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderRequest {

    @NotNull
    @Digits(integer = 10, fraction = 0)
    private Long deliveryId;

    @NotNull
    @Digits(integer = 10, fraction = 0)
    private Long customerId;

    @NotEmptyArray
    private Long[] productIds;
}
