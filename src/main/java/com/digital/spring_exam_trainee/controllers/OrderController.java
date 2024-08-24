package com.digital.spring_exam_trainee.controllers;

import com.digital.spring_exam_trainee.common.ApiResponse;
import com.digital.spring_exam_trainee.dto.requests.CustomerRequest;
import com.digital.spring_exam_trainee.dto.requests.OrderRequest;
import com.digital.spring_exam_trainee.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<?> index(){
        return ApiResponse.collectionResponse(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        return ApiResponse.singleResponse(this.orderService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> store(@Valid @RequestBody OrderRequest orderRequest) {
        return ApiResponse.messageWithSingleResponse(
                "Order created successfully",
                this.orderService.create(orderRequest),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @Valid @RequestBody OrderRequest orderRequest) {
        return ApiResponse.messageWithSingleResponse(
                "Order updated successfully",
                this.orderService.update(id, orderRequest),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        this.orderService.deleteById(id);
        return ApiResponse.messageResponse("Order deleted successfully", HttpStatus.OK);
    }
}
