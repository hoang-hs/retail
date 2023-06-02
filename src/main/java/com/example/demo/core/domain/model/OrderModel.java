package com.example.demo.core.domain.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "order_info")
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "product_id")
    Long productId;
    Integer number;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    Timestamp updatedAt;

    public OrderModel(Long productId, Integer number) {
        this.productId = productId;
        this.number = number;
    }

    public OrderModel() {
    }
}
