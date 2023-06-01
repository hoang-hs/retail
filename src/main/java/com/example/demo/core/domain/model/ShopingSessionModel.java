package com.example.demo.core.domain.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "shoping_session")
public class ShopingSessionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "user_id")
    String UserId;

    @ElementCollection
    List<Long> orders;
    Long total;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    Timestamp updatedAt;

}
