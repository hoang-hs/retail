package com.example.demo.present.controller;

import com.example.demo.core.domain.model.stockModel;
import com.example.demo.core.service.stockService;
import com.example.demo.present.requests.addProductToStockRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class stockController {

    private final stockService stockService;

    @Autowired
    public stockController(stockService stockService) {
        this.stockService = stockService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/stock")
    stockModel create(@RequestBody @Valid addProductToStockRequest req) {
        return stockService.save(req);
    }

}
