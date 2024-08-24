package com.digital.spring_exam_trainee.services;

import com.digital.spring_exam_trainee.dto.DeliveryDto;

import java.util.List;

public interface DeliveryService {
    List<DeliveryDto> findAll();
    DeliveryDto findById(Long id);
}
