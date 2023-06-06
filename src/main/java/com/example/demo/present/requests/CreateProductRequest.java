package com.example.demo.present.requests;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateProductRequest {
    @NotBlank
    String name;
    String description;
    @NotNull
    @Min(value = 0)
    Long price;

    @NotNull
    @Min(value = 1)
    Integer number;

    public CreateProductRequest() {
        price = 0L;
        number = 0;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public @NotNull Long getPrice() {
        return price;
    }

    public @NotNull Integer getNumber() {
        return number;
    }
}
