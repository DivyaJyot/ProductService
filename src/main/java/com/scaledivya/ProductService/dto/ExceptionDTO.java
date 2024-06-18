package com.scaledivya.ProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDTO {
    private Long productId;
    private String message;
}
