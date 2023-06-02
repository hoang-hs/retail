package com.example.demo.core.domain;

import com.example.demo.core.domain.model.ShopingSessionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopingSessionRepository extends JpaRepository<ShopingSessionModel, Long> {

}
