package com.digital.spring_exam_trainee.dto;

import com.digital.spring_exam_trainee.models.Delivery;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class DeliveryDto {
    private Long id;

    private String type;
    // PENDING,DELIVERED, CANCELLED
    private String status;

    public DeliveryDto(Delivery delivery){
        BeanUtils.copyProperties(delivery, this);
    }

    public Delivery toEntity(){
        Delivery delivery = new Delivery();
        BeanUtils.copyProperties(this, delivery);
        return delivery;
    }
}
