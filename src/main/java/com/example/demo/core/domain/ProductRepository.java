package com.example.demo.core.domain;

import com.example.demo.core.domain.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    Optional<ProductModel> findByName(String name);

}
