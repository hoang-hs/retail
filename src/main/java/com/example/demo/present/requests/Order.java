package com.example.demo.present.requests;

import ch.qos.logback.core.model.INamedModel;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Order {
    @NotBlank
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
