package com.digital.spring_exam_trainee.services;

import com.digital.spring_exam_trainee.dto.DeliveryDto;
import com.digital.spring_exam_trainee.dto.requests.DeliveryRequest;

import java.util.List;

public interface DeliveryService {
    List<DeliveryDto> findAll();
    DeliveryDto findById(Long id);
    DeliveryDto create(DeliveryRequest deliveryRequest);
    DeliveryDto update(Long id, DeliveryRequest deliveryRequest);
    void deleteById(Long id);
}
