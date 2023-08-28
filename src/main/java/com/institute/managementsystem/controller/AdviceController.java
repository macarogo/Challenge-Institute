package com.institute.managementsystem.controller;

import com.institute.managementsystem.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AdviceController {

    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handlevalidateExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<String, String>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName= ((FieldError) error).getField();
            String message= error.getDefaultMessage();

            errors.put(fieldName, message);
        });
        return errors;
    }

    @ExceptionHandler(value= RuntimeException.class)
    public ResponseEntity<ErrorDto> runtimeExceptionHandler(RuntimeException ex){
        ErrorDto error= ErrorDto.builder().code("P-404").message("Does not exist").build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
