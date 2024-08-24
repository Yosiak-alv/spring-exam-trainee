package com.digital.spring_exam_trainee.services;

import com.digital.spring_exam_trainee.dto.OrderDto;
import com.digital.spring_exam_trainee.dto.requests.OrderRequest;

import java.util.List;

public interface OrderService {
    List<OrderDto> findAll();
    OrderDto findById(Long id);
    OrderDto create(OrderRequest orderRequest);
    OrderDto update(Long id, OrderRequest orderRequest);
    void deleteById(Long id);
}
