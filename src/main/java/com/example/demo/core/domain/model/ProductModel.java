package com.example.demo.core.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "product")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "description")
    String description;
    @Column(name = "price", nullable = false)
    Long price;
    @Column(name = "number", nullable = false)
    Integer number;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    @JsonProperty("created_at")
    Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    @JsonProperty("updated_at")
    Timestamp updatedAt;

    public ProductModel(String name, String desc, Long price, Integer number) {
        this.name = name;
        this.description = desc;
        this.price = price;
        this.number = number;
    }

    public ProductModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
