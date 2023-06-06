package com.example.demo.present.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CreateShopingSessionRequest {
    @NotEmpty
    List<Order> orders;

    @NotNull
    @Min(0)
    @JsonProperty("customer_id")
    Long customerId;

    public List<Order> getOrders() {
        return orders;
    }

    public @NotNull Long getCustomerId() {
        return customerId;
    }
}
