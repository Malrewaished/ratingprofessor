package com.example.finalproject.advise;
import com.example.finalproject.dto.Api;
import com.example.finalproject.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAdvise {
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity apiException(ApiException apiException){
        return ResponseEntity.status(400).body(new Api(apiException.getMessage(), 400));
    }
}