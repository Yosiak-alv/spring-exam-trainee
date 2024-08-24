package com.digital.spring_exam_trainee.services.impl;

import com.digital.spring_exam_trainee.dto.DeliveryDto;
import com.digital.spring_exam_trainee.dto.ProductDto;
import com.digital.spring_exam_trainee.dto.requests.DeliveryRequest;
import com.digital.spring_exam_trainee.exceptions.ResourceNotFoundException;
import com.digital.spring_exam_trainee.models.Delivery;
import com.digital.spring_exam_trainee.models.Product;
import com.digital.spring_exam_trainee.repositories.DeliveryRepository;
import com.digital.spring_exam_trainee.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Delivery delivery = this.findModelById(id);
        return new DeliveryDto(delivery);
    }

    @Override
    public DeliveryDto create(DeliveryRequest deliveryRequest) {
        Delivery newDelivery = new Delivery();
        newDelivery.setType(deliveryRequest.getType());
        newDelivery.setStatus(deliveryRequest.getStatus());
        return new DeliveryDto(this.repository.save(newDelivery));
    }

    @Override
    public DeliveryDto update(Long id, DeliveryRequest deliveryRequest) {
        Delivery delivery = this.findModelById(id);
        if (delivery != null) {
            delivery.setType(deliveryRequest.getType());
            delivery.setStatus(deliveryRequest.getStatus());
            return new DeliveryDto(this.repository.save(delivery));
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Delivery delivery = this.findModelById(id);
        if(delivery != null){this.repository.deleteById(delivery.getId());}
    }

    private Delivery findModelById(Long id) {
        return this.repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery not found with id: " + id));
    }
}
