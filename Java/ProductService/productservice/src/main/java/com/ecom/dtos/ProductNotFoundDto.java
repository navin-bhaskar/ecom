package com.ecom.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundDto {
    String productId;
    String errorMessage;

    public ProductNotFoundDto() {
        this.errorMessage = "The product was not found";
    }

}
