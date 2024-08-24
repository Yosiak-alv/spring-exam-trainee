package com.digital.spring_exam_trainee.dto;

import com.digital.spring_exam_trainee.models.Order;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class OrderDto {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;

    private DeliveryDto delivery;

    private CustomerDto customer;

    private Set<ProductDto> products;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.orderDate = order.getOrderDate();
        this.delivery = new DeliveryDto(order.getDelivery());
        this.customer = new CustomerDto(order.getCustomer());
        this.products = order.getProducts().stream().map(ProductDto::new).collect(Collectors.toSet());

    }

    public Order toEntity() {
        Order order = new Order();
        order.setId(this.id);
        order.setOrderDate(this.orderDate);
        order.setDelivery(this.delivery.toEntity());
        order.setCustomer(this.customer.toEntity());
        order.setProducts(this.products.stream().map(ProductDto::toEntity).collect(Collectors.toSet()));
        return order;
    }
}
