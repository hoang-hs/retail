package com.example.demo.core.domain;

import com.example.demo.core.domain.model.stockModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface stockRepository extends JpaRepository<stockModel, Long> {
    Optional<stockModel> findByProductId(Long id);

}
