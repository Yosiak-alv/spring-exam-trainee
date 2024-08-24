package com.digital.spring_exam_trainee.services.impl;

import com.digital.spring_exam_trainee.dto.DeliveryDto;
import com.digital.spring_exam_trainee.dto.ProductDto;
import com.digital.spring_exam_trainee.exceptions.ResourceNotFoundException;
import com.digital.spring_exam_trainee.models.Delivery;
import com.digital.spring_exam_trainee.models.Product;
import com.digital.spring_exam_trainee.repositories.DeliveryRepository;
import com.digital.spring_exam_trainee.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepository repository;

    @Override
    public List<DeliveryDto> findAll() {
        return this.repository.findAll().stream().map(DeliveryDto::new).toList();
    }

    @Override
    public DeliveryDto findById(Long id) {
        Delivery delivery = this.repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery not found with id: " + id));
        return new DeliveryDto(delivery);
    }
}
