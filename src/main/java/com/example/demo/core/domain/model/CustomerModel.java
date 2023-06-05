package com.example.demo.core.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "customer")
@Getter
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    String name;
    @Column(name = "telephone", nullable = false, unique = true)
    String telephone;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    @JsonProperty("created_at")
    Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    @JsonProperty("updated_at")
    Timestamp updatedAt;

    public CustomerModel(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public CustomerModel() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
}
