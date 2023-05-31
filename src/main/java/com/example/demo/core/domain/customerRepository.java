package com.example.demo.core.domain;

import com.example.demo.core.domain.model.customerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customerRepository extends JpaRepository<customerModel, Long> {

}
