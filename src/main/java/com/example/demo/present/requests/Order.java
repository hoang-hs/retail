package com.example.demo.present.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Order {
    @NotBlank
    @JsonProperty("product_id")
    Long productId;
    @Min(0)
    Integer number;

    public Long getProductId() {
        return productId;
    }

    public Integer getNumber() {
        return number;
    }
}
