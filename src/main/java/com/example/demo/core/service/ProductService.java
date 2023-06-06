package com.example.demo.core.service;

import com.example.demo.core.domain.ProductRepository;
import com.example.demo.core.domain.model.ProductModel;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.present.requests.CreateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductModel save(CreateProductRequest req) {
        Optional<ProductModel> optionalProduct = productRepository.findByName(req.getName());
        if (optionalProduct.isPresent()) {
            throw ResourceNotFoundException.WithMessage("name of product have been exist");
        }
        ProductModel p = new ProductModel(req.getName(), req.getDescription(), req.getPrice(), req.getNumber());
        productRepository.save(p);
        return p;
    }

    public ProductModel get(Long id) {
        Optional<ProductModel> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw ResourceNotFoundException.WithMessage("product not found");
        }
        return optionalProduct.get();
    }
}
