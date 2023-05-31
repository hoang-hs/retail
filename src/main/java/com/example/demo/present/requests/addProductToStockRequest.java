package com.example.demo.present.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;

public class addProductToStockRequest {
    @Min(0)
    @JsonProperty("product_id")
    Long productId;

    Integer number;

    public Long getProductId() {
        return productId;
    }

    public Integer getNumber() {
        return number;
    }
}
