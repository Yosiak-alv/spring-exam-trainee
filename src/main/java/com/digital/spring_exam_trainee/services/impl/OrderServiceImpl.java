package com.digital.spring_exam_trainee.services.impl;

import com.digital.spring_exam_trainee.dto.CustomerDto;
import com.digital.spring_exam_trainee.dto.DeliveryDto;
import com.digital.spring_exam_trainee.dto.OrderDto;
import com.digital.spring_exam_trainee.dto.ProductDto;
import com.digital.spring_exam_trainee.dto.requests.OrderRequest;
import com.digital.spring_exam_trainee.exceptions.ResourceNotFoundException;
import com.digital.spring_exam_trainee.models.Order;
import com.digital.spring_exam_trainee.models.Product;
import com.digital.spring_exam_trainee.repositories.OrderRepository;
import com.digital.spring_exam_trainee.services.CustomerService;
import com.digital.spring_exam_trainee.services.DeliveryService;
import com.digital.spring_exam_trainee.services.OrderService;
import com.digital.spring_exam_trainee.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductService productService;

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private CustomerService customerService;

    @Override
    public List<OrderDto> findAll() {
        return this.repository.findAll().stream().map(OrderDto::new).toList();
    }

    @Override
    public OrderDto findById(Long id) {
        Order order = this.repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
        return new OrderDto(order);
    }

    @Override
    public OrderDto create(OrderRequest orderRequest) {
        Order newOrder = new Order();
        CustomerDto customerDto = customerService.findById(orderRequest.getCustomerId());
        DeliveryDto deliveryDto = deliveryService.findById(orderRequest.getDeliveryId());
        List<Product> products = productService.findByIds(orderRequest.getProductIds());
        if(customerDto != null && deliveryDto != null && products.size() == orderRequest.getProductIds().length){
            newOrder.setDelivery(deliveryDto.toEntity());
            newOrder.setCustomer(customerDto.toEntity());
            newOrder.setProducts(new HashSet<>(products));
            return new OrderDto(this.repository.save(newOrder));
        }
        return null;
    }

    @Override
    public OrderDto update(Long id, OrderRequest orderRequest) {
        OrderDto order = this.findById(id);
        CustomerDto customerDto = customerService.findById(orderRequest.getCustomerId());
        DeliveryDto deliveryDto = deliveryService.findById(orderRequest.getDeliveryId());
        List<Product> products = productService.findByIds(orderRequest.getProductIds());

        if(customerDto != null && deliveryDto != null && products.size() == orderRequest.getProductIds().length){
            Order newOrder = order.toEntity();
            newOrder.getProducts().clear();
            newOrder.setDelivery(deliveryDto.toEntity());
            newOrder.setCustomer(customerDto.toEntity());
            newOrder.setProducts(new HashSet<>(products));
            return new OrderDto(this.repository.save(newOrder));
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        OrderDto orderDto = this.findById(id);
        this.repository.deleteById(orderDto.getId());
    }
}