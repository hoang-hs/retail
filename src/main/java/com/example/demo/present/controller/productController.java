package com.example.demo.present.controller;

import com.example.demo.core.domain.model.productModel;
import com.example.demo.core.service.productService;
import com.example.demo.present.requests.createProductRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class productController {

    private final productService productService;

    @Autowired
    public productController(productService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/product")
    productModel create(@RequestBody @Valid createProductRequest req) {
        return productService.save(req);
    }

}
