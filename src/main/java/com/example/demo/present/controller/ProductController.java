package com.example.demo.present.controller;

import com.example.demo.core.domain.model.ProductModel;
import com.example.demo.core.service.ProductService;
import com.example.demo.present.requests.CreateProductRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/product")
    ProductModel create(@RequestBody @Valid CreateProductRequest req) {
        return productService.save(req);
    }



}
