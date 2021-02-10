package com.blockinarC19.Configuration;

import com.blockinarC19.Exception.BadRequestException;
import com.blockinarC19.Exception.NotFoundException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
//This helps to handle the code exceptions.
// To call them : (annotation  = "location from where it will b made the calls (controller)

public class ExceptionConfiguration {

    private String generateJsonResponse(Exception  e) {
        JSONObject response = new JSONObject();
        response.put("error", e.getMessage());
        return response.toString();
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(generateJsonResponse(e));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(Exception  e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(generateJsonResponse(e));
    }
}