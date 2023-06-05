package com.example.demo.present.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class CreateShopingSessionRequest {
    @NotEmpty
    List<Order> orders;

    @Min(0)
    @JsonProperty("customer_id")
    Long customerId;

    public List<Order> getOrders() {
        return orders;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
