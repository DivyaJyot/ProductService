package com.scaledivya.ProductService.service;

import com.scaledivya.ProductService.exception.InvalidProductIdException;
import com.scaledivya.ProductService.model.Category;
import com.scaledivya.ProductService.model.Product;
import com.scaledivya.ProductService.repository.CategoryRepository;
import com.scaledivya.ProductService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) throws InvalidProductIdException {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()){
            return null;
        }
        return product.get();
    }

    @Override
    public void deleteProduct(Long id) {
            productRepository.deleteById(id);
    }

    @Override
    public Product createProduct(Product product) {
        Category cat= product.getCategory();
        Optional<Category> cat2=categoryRepository.findByTitle(cat.getTitle());
        if(!cat2.isPresent())
            categoryRepository.save(cat);

        else{
            product.setCategory(cat2.get());
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
        return productRepository.save(product);
    }
}
