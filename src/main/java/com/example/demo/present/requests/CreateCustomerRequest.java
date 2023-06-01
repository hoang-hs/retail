package com.example.demo.present.requests;

import jakarta.validation.constraints.NotBlank;

public class CreateCustomerRequest {
    @NotBlank
    String name;

    @NotBlank
    String telephone;
    //Todo validate telephone

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }
}
