package com.example.demo.core.domain;

import com.example.demo.core.domain.model.StockModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<StockModel, Long> {
    Optional<StockModel> findByProductId(Long id);

}
