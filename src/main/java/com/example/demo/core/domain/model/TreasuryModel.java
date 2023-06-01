package com.example.demo.core.domain.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@Table(name = "treasury")
public class TreasuryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    Long productId;
    Integer number;
    Long total;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    Timestamp updatedAt;

}
