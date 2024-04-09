package com.ecom.advices;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecom.dtos.ProductNotFoundDto;
import com.ecom.exceptions.InvalidProductIdException;

@ControllerAdvice
public class ProductControlAdvice {
    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ProductNotFoundDto> handleProductNotFound(InvalidProductIdException exp) {
        ProductNotFoundDto dto = new ProductNotFoundDto();
        dto.setProductId(Long.toString(exp.getProductId()));
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
