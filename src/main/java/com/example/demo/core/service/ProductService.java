package com.example.demo.core.service;

import com.example.demo.core.domain.ProductRepository;
import com.example.demo.core.domain.model.ProductModel;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.present.requests.AddNumberProductRequest;
import com.example.demo.present.requests.CreateProductRequest;
import com.example.demo.present.requests.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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


    public Page<ProductModel> getList(PageRequest req) {
        return productRepository.findAll(req.buildPageable());
    }

    public ProductModel addNumber(Long id, AddNumberProductRequest req) {
        Optional<ProductModel> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw BadRequestException.WithMessage("product not found");
        }
        ProductModel product = optionalProduct.get();
        product.setNumber(product.getNumber() + req.getNumber());
        return productRepository.save(product);
    }

}
