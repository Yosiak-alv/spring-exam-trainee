package com.digital.spring_exam_trainee.services.impl;

import com.digital.spring_exam_trainee.dto.CategoryDto;
import com.digital.spring_exam_trainee.dto.CustomerDto;
import com.digital.spring_exam_trainee.dto.requests.CustomerRequest;
import com.digital.spring_exam_trainee.exceptions.ResourceNotFoundException;
import com.digital.spring_exam_trainee.models.Category;
import com.digital.spring_exam_trainee.models.Customer;
import com.digital.spring_exam_trainee.repositories.CustomerRepository;
import com.digital.spring_exam_trainee.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    //TODO when updating a customer if this is in a order, delete the association with the order, so the order will not have this customer anymore
    //TODO fix this
    @Autowired
    private CustomerRepository repository;
    @Override
    public List<CustomerDto> findAll() {
        return this.repository.findAll().stream().map(CustomerDto::new).toList();
    }

    @Override
    public CustomerDto findById(Long id) {
        Customer customer = this.repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
        return new CustomerDto(customer);
    }

    @Override
    public CustomerDto create(CustomerRequest customerRequest) {
        Customer newCustomer = new Customer();
        newCustomer.setName(customerRequest.getName());
        newCustomer.setEmail(customerRequest.getEmail());
        newCustomer.setAddress(customerRequest.getAddress());
        return new CustomerDto(this.repository.save(newCustomer));
    }

    @Override
    public CustomerDto update(Long id, CustomerRequest customerRequest) {
        CustomerDto customerDto = this.findById(id);
        Customer customer = customerDto.toEntity();
        customer.setName(customerRequest.getName());
        customer.setEmail(customerRequest.getEmail());
        customer.setAddress(customerRequest.getAddress());
        return new CustomerDto(this.repository.save(customer));
    }

    @Override
    public void deleteById(Long id) {
        CustomerDto customerDto = this.findById(id);
        this.repository.deleteById(customerDto.getId());
    }
}
