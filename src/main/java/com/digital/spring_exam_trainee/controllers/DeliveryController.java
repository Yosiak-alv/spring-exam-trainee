package com.digital.spring_exam_trainee.controllers;

import com.digital.spring_exam_trainee.common.ApiResponse;
import com.digital.spring_exam_trainee.dto.requests.DeliveryRequest;
import com.digital.spring_exam_trainee.services.DeliveryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/deliveries")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public ResponseEntity<?> index(){
        return ApiResponse.collectionResponse(this.deliveryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        return ApiResponse.singleResponse(this.deliveryService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> store(@Valid @RequestBody DeliveryRequest deliveryRequest){
        return ApiResponse.messageWithSingleResponse(
                "Delivery created successfully",
                this.deliveryService.create(deliveryRequest),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@PathVariable Long id, @Valid @RequestBody DeliveryRequest deliveryRequest){
        return ApiResponse.messageWithSingleResponse(
                "Delivery updated successfully",
                this.deliveryService.update(id, deliveryRequest),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> destroy(@PathVariable Long id){
        this.deliveryService.deleteById(id);
        return ApiResponse.messageResponse("Delivery deleted successfully", HttpStatus.OK);
    }
}
