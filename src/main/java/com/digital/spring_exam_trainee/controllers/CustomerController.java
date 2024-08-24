package com.digital.spring_exam_trainee.controllers;

import com.digital.spring_exam_trainee.common.ApiResponse;
import com.digital.spring_exam_trainee.dto.requests.CustomerRequest;
import com.digital.spring_exam_trainee.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> index(){
        return ApiResponse.collectionResponse(customerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        return ApiResponse.singleResponse(this.customerService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> store(@Valid @RequestBody CustomerRequest customerRequest) {
        return ApiResponse.messageWithSingleResponse(
                "Client created successfully",
                this.customerService.create(customerRequest),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @Valid @RequestBody CustomerRequest customerRequest) {
        return ApiResponse.messageWithSingleResponse(
                "Client updated successfully",
                this.customerService.update(id, customerRequest),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        this.customerService.deleteById(id);
        return ApiResponse.messageResponse("Client deleted successfully", HttpStatus.OK);
    }
}
