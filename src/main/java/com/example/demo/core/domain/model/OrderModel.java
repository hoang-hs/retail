package com.example.demo.core.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
