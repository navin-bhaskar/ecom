package com.ecom.exceptions;

import lombok.Getter;

@Getter
public class InvalidProductIdException extends Exception {
    private Long productId;
    public InvalidProductIdException(Long prodId) {
        super();
        this.productId = prodId;
    }
    
}
