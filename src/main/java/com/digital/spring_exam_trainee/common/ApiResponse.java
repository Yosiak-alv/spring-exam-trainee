package com.digital.spring_exam_trainee.common;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@Data
public class ApiResponse {

    public static ResponseEntity<Object> collectionResponse(Object data, HttpStatus status) {
        Map<String, Object> response = Map.of("data", data);
        return new ResponseEntity<>(response, status);
    }

    public static ResponseEntity<Object> singleResponse(Object data, HttpStatus status) {
        Map<String, Object> response = Map.of("data", data);
        return new ResponseEntity<>(response, status);
    }

    public static ResponseEntity<Object> messageWithSingleResponse(String message, Object data, HttpStatus status) {
        Map<String, Object> response = Map.of("message", message, "data", data);
        return new ResponseEntity<>(response, status);
    }
    public static ResponseEntity<Object> messageResponse(String message, HttpStatus status) {
        Map<String, Object> response = Map.of("message", message);
        return new ResponseEntity<>(response, status);
    }

}
