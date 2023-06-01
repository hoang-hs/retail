package com.example.demo.present.requests;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateProductRequest {
    @NotBlank
    String name;
    String description;
    @Min(value = 0)
    Long price;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getPrice() {
        return price;
    }
}
