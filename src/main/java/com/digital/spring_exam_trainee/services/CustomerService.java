package com.digital.spring_exam_trainee.services;

import com.digital.spring_exam_trainee.dto.CustomerDto;
import com.digital.spring_exam_trainee.dto.requests.CustomerRequest;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> findAll();
    CustomerDto findById(Long id);
    CustomerDto create(CustomerRequest customerRequest);
    CustomerDto update(Long id, CustomerRequest customerRequest);
    void deleteById(Long id);
}
