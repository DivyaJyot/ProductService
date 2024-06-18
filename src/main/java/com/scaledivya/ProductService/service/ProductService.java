package com.scaledivya.ProductService.service;

import com.scaledivya.ProductService.exception.InvalidProductIdException;
import com.scaledivya.ProductService.model.Product;
import com.scaledivya.ProductService.projection.ProductWithIdAndTitle;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

   public  List<Product> getAllProducts();
    public Product getProductById(Long id) throws InvalidProductIdException;

    public void deleteProduct(Long id);

    public Product createProduct(Product product);

    public Product updateProduct(Long productId,Product product);

    public Product replaceProduct(Long productId, Product product);


 public List<ProductWithIdAndTitle> getFilteredProduct();
 public ProductWithIdAndTitle getspecificProduct();



}
