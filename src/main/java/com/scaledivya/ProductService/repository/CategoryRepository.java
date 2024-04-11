package com.scaledivya.ProductService.repository;

import com.scaledivya.ProductService.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Override
    Optional<Category> findById(Long aLong);

    Optional<Category> findByTitle(String Tile);


    @Override
    <S extends Category> S save(S entity);
}
