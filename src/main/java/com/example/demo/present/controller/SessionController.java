package com.example.demo.present.controller;

import com.example.demo.core.domain.model.ShopingSessionModel;
import com.example.demo.core.service.SessionService;
import com.example.demo.present.requests.CreateShopingSessionRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    private final SessionService sessionService;

    @Autowired
    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/shop")
    public ShopingSessionModel create(@RequestBody @Valid CreateShopingSessionRequest req) {
        return sessionService.save(req);
    }
}
