package com.example.demo.core.service;

import com.example.demo.core.domain.model.productModel;
import com.example.demo.core.domain.productRepository;
import com.example.demo.exception.AppException;
import com.example.demo.present.requests.createProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class productService {
    private final productRepository productRepository;

    @Autowired
    public productService(productRepository productRepository) {
        this.productRepository = productRepository;
    }

    public productModel save(createProductRequest req) {
        Optional<productModel> existProduct = productRepository.findByName(req.getName());
        if (existProduct.isPresent()) {
            throw new AppException("name of product have been exist", HttpStatus.NOT_IMPLEMENTED);
        }
        productModel p = new productModel(req.getName(), req.getDescription(), req.getPrice());
        productRepository.save(p);
        return p;
    }
}
