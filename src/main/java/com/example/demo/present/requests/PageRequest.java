package com.example.demo.present.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.Pageable;

public class PageRequest {
    @Min(0)
    @JsonProperty("page")
    Integer page;
    @Min(0)
    @JsonProperty("size")
    Integer size;


    public PageRequest() {
        page = 1;
        size = 10;
    }

    public Integer getPage() {
        return page - 1;
    }


    public Integer getSize() {
        return this.size;
    }

    public Pageable buildPageable() {
        return org.springframework.data.domain.PageRequest.of(getPage(), getSize());
    }
}
