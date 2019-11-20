package com.example.demo;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobelExceptionHandler {

    @ExceptionHandler(Exc.class)
    public ResponseEntity<Object> Arithmetic(Exception e) {
        switch (e.getMessage()) {
            case "1":
                return new ResponseEntity<>("1111", HttpStatus.BAD_GATEWAY);
            case "2":
                return new ResponseEntity<>("2222", HttpStatus.BAD_GATEWAY);
            default:
                return new ResponseEntity<>("sad", HttpStatus.BAD_GATEWAY);
        }
    }

}
