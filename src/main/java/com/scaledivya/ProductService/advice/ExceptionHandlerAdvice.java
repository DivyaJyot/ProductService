package com.scaledivya.ProductService.advice;

import com.scaledivya.ProductService.dto.ExceptionDTO;
import com.scaledivya.ProductService.exception.InvalidProductIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {



    @ExceptionHandler({ InvalidProductIdException.class })
    public final ResponseEntity<ExceptionDTO> handleException(InvalidProductIdException ex) {
        ExceptionDTO dto= new ExceptionDTO();
        dto.setMessage(ex.getMessage());
        dto.setProductId(ex.getProductId());
        return  new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
