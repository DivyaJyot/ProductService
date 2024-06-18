package com.scaledivya.ProductService;

/**
 * Projection for {@link com.scaledivya.ProductService.model.Product}
 */
public interface ProductInfo {
    String getTitle();

    double getPrice();

    String getDescription();
}