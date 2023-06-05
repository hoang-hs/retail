package com.example.demo.core.domain.model;

import com.example.demo.present.requests.Order;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Entity
@AllArgsConstructor
@Table(name = "shoping_session")
public class ShopingSessionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "user_id")
    Long userId;

//    @Convert(converter = JpaConverterJson.class)
    @Type(type = "json")
    @Column(columnDefinition = "json")
    List<OrderModel> orders;

    Long total;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    Timestamp updatedAt;


    public ShopingSessionModel(Long userId, List<OrderModel> orders, Long total) {
        this.userId = userId;
        this.orders = orders;
        this.total = total;
    }

    public ShopingSessionModel() {

    }
}
