package com.example.demo.present.requests;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateProductRequest {
    @NotBlank
    String name;
    String description;
    @Min(value = 0)
    Long price;

    @Min(value = 1)
    Integer number;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getPrice() {
        return price;
    }

    public Integer getNumber() {
        return number;
    }
}
