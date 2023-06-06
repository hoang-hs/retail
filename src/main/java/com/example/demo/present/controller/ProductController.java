package com.example.demo.present.controller;

import com.example.demo.core.domain.model.ProductModel;
import com.example.demo.core.service.ProductService;
import com.example.demo.present.requests.AddNumberProductRequest;
import com.example.demo.present.requests.CreateProductRequest;
import com.example.demo.present.requests.PageRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/products")
    ProductModel create(@RequestBody @Valid CreateProductRequest req) {
        return productService.save(req);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/products/{id}")
    ProductModel get(@PathVariable(value = "id") Long id) {
        return productService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/products")
    Page<ProductModel> getList(@Valid PageRequest req) {
        return productService.getList(req);
    }

    @PostMapping("/products/{id}")
    ProductModel addNumber(@PathVariable(value = "id") Long id, @RequestBody AddNumberProductRequest req) {
        return productService.addNumber(id, req);
    }

}
