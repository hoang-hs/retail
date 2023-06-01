package com.example.demo.core.service;

import com.example.demo.core.domain.model.StockModel;
import com.example.demo.core.domain.StockRepository;
import com.example.demo.present.requests.AddProductToStockRequest;
import com.example.demo.present.requests.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {
    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public StockModel save(AddProductToStockRequest req) {
        StockModel stock;
        Optional<StockModel> existProduct = stockRepository.findByProductId(req.getProductId());
        if (existProduct.isPresent()) {
            stock = existProduct.get();
            stock.setNumber(stock.getNumber() + req.getNumber());
        } else {
            stock = new StockModel(req.getProductId(), req.getNumber());
        }
        return stockRepository.save(stock);
    }

    public Page<StockModel> getList(PageRequest req) {
        Page<StockModel> stocks = stockRepository.findAll(req.buildPageable());
        return stocks;
    }
}
