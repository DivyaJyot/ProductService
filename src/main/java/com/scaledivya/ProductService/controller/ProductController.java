package com.scaledivya.ProductService.controller;

import com.scaledivya.ProductService.commons.AuthorizationCommons;
import com.scaledivya.ProductService.exception.InvalidProductIdException;
import com.scaledivya.ProductService.model.Product;
import com.scaledivya.ProductService.model.Userdto;
import com.scaledivya.ProductService.projection.ProductWithIdAndTitle;
import com.scaledivya.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
@Autowired
    private ProductService productService;
@Autowired
private AuthorizationCommons authenticationComm;

    ProductController(@Qualifier("SelfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/id")
    public ResponseEntity<?> getProduct(@RequestParam Long id) throws InvalidProductIdException {
        return new ResponseEntity<Product>(productService.getProductById(id),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductSpecific(@PathVariable("id") Long id ) throws InvalidProductIdException {
        return new ResponseEntity<ProductWithIdAndTitle>((ProductWithIdAndTitle) productService.getProductById(id),HttpStatus.OK);
    }

    @GetMapping("/token/{token}")
    public ResponseEntity<?> getAllProducts(@PathVariable String token) {
        Userdto userdto=authenticationComm.validateToken(token);
        if(userdto==null){
            System.out.println("token invalid");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
    }

    @PostMapping//http:localhost:8082/products
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.createProduct(product),HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(id,product),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable Long id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(id,product),HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {

    }

    @GetMapping("/filtered")
    public ResponseEntity<?> getFilteredProduct() throws InvalidProductIdException {
        return new ResponseEntity<>(productService.getFilteredProduct(),HttpStatus.OK);
    }
}

