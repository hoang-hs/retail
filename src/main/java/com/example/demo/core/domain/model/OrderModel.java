package com.example.demo.core.domain.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

public class OrderModel {
    @JsonProperty("product_id")
    Long productId;
    @JsonProperty("number")
    Integer number;

    public OrderModel(Long productId, Integer number) {
        this.productId = productId;
        this.number = number;
    }

    public OrderModel() {
    }
}
