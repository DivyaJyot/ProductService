package com.scaledivya.ProductService.repository;

import com.scaledivya.ProductService.model.Product;
import com.scaledivya.ProductService.projection.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    List<Product> findAll();

    List<Product> findTopThreeByTitle(String title);

    List<Product> findByTitleContaining(String word);

    void deleteByTitle(String title);

    @Override
    <S extends Product> S save(S entity);
    @Query("select p.id as id, p.title as title from Product p where p.price<40000")
    List<ProductWithIdAndTitle> executeCustomeQuery();
}
