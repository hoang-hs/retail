package com.example.demo.present.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class CreateShopingSessionRequest {
    @NotBlank
    List<Order> orders;

    @Min(0)
    Long userId;

    public List<Order> getOrders() {
        return orders;
    }

    public Long getUserId() {
        return userId;
    }
}
