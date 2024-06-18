package com.scaledivya.ProductService.controller;

import com.scaledivya.ProductService.exception.InvalidProductIdException;
import com.scaledivya.ProductService.model.Product;
import com.scaledivya.ProductService.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;
    @Test
    void getProductById() throws InvalidProductIdException {
           Long id= 1000L;
        Product product= new Product();
        product.setId(1000);
        Boolean Product;
        when(productService.getProductById(1000l)). thenReturn(product);
        ResponseEntity<?> expectedResponse = productController.getProduct(id);
        assertEquals(HttpStatus.OK,expectedResponse.getStatusCode());
        assertEquals(product,expectedResponse.getBody());
    }

    @Test
    void getFilteredProduct() {
    }

    @Test
    void getProductSpecific() throws InvalidProductIdException {


    }

    @Test
    void replaceProduct() {
    }
}