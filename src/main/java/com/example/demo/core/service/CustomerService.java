package com.example.demo.core.service;

import com.example.demo.core.domain.CustomerRepository;
import com.example.demo.core.domain.model.CustomerModel;
import com.example.demo.exception.AppException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.present.requests.CreateCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public CustomerModel save(CreateCustomerRequest req) {
        Optional<CustomerModel> optionalProduct = customerRepository.findByTelephone(req.getName());
        if (optionalProduct.isPresent()) {
            throw new AppException("name of product have been exist", HttpStatus.NOT_IMPLEMENTED);
        }
        CustomerModel p = new CustomerModel(req.getName(), req.getTelephone());
        customerRepository.save(p);
        return p;
    }

    public CustomerModel get(String telephone) {
        Optional<CustomerModel> optionalProduct = customerRepository.findByTelephone(telephone);
        if (optionalProduct.isEmpty()) {
            throw ResourceNotFoundException.Default();
        }
        return optionalProduct.get();
    }

}
