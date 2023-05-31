package com.example.demo.core.service;

import com.example.demo.core.domain.model.stockModel;
import com.example.demo.core.domain.stockRepository;
import com.example.demo.present.requests.addProductToStockRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class stockService {
    private final stockRepository stockRepository;

    @Autowired
    public stockService(stockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public stockModel save(addProductToStockRequest req) {
        stockModel stock;
        Optional<stockModel> existProduct = stockRepository.findByProductId(req.getProductId());
        if (existProduct.isPresent()) {
            stock = existProduct.get();
            stock.setNumber(stock.getNumber() + req.getNumber());
        } else {
            stock = new stockModel(req.getProductId(), req.getNumber());
        }
        return stockRepository.save(stock);
    }
}
