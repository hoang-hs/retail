package com.example.demo.present.controller;

import com.example.demo.core.domain.model.CustomerModel;
import com.example.demo.core.service.CustomerService;
import com.example.demo.present.requests.CreateCustomerRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/customers")
    CustomerModel create(@RequestBody @Valid CreateCustomerRequest req) {
        return customerService.save(req);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/customers")
    CustomerModel get(@RequestParam String telephone) {
        return customerService.get(telephone);
    }


}
