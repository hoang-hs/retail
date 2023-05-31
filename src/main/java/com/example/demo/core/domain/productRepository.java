package com.example.demo.core.domain;

import com.example.demo.core.domain.model.productModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface productRepository extends JpaRepository<productModel, Long> {
    Optional<productModel> findByName(String name);

}
