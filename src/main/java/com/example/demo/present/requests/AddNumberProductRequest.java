package com.example.demo.present.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class AddNumberProductRequest {
    @NotNull
    @Min(0)
    Integer number;

    public AddNumberProductRequest() {
        number = 0;
    }

    public @NotNull Integer getNumber() {
        return number;
    }
}
