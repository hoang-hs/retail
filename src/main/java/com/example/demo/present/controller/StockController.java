package com.example.demo.present.controller;

import com.example.demo.core.domain.model.StockModel;
import com.example.demo.core.service.StockService;
import com.example.demo.present.requests.AddProductToStockRequest;
import com.example.demo.present.requests.PageRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/stock")
    StockModel create(@RequestBody @Valid AddProductToStockRequest req) {
        return stockService.save(req);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/stock")
    Page<StockModel> getList(@Valid PageRequest req) {
        return stockService.getList(req);
    }

}
