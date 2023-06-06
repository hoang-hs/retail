package com.example.demo.core.service;

import com.example.demo.core.domain.CustomerRepository;
import com.example.demo.core.domain.ProductRepository;
import com.example.demo.core.domain.ShopingSessionRepository;
import com.example.demo.core.domain.model.CustomerModel;
import com.example.demo.core.domain.model.OrderModel;
import com.example.demo.core.domain.model.ProductModel;
import com.example.demo.core.domain.model.ShopingSessionModel;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.present.requests.CreateShopingSessionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class SessionService {
    private final ShopingSessionRepository sessionRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public SessionService(ShopingSessionRepository sessionRepository, ProductRepository productRepository, CustomerRepository customerRepository) {
        this.sessionRepository = sessionRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    public ShopingSessionModel save(CreateShopingSessionRequest req) {
        validate(req);
        Long total = calculateTotal(req);

        List<OrderModel> orders = new ArrayList<>();
        req.getOrders().forEach(i -> orders.add(new OrderModel(i.getProductId(), i.getNumber())));
        ShopingSessionModel sessionModel = new ShopingSessionModel(req.getCustomerId(), orders, total);
        return sessionRepository.save(sessionModel);
    }

    void validate(CreateShopingSessionRequest req) {
        Optional<CustomerModel> customerModel = customerRepository.findById(req.getCustomerId());
        if (customerModel.isEmpty()) {
            throw ResourceNotFoundException.WithMessage("customer not found");
        }
    }

    Long calculateTotal(CreateShopingSessionRequest req) {
        Set<Long> setProductId = new HashSet<>();
        req.getOrders().forEach(i -> setProductId.add(i.getProductId()));
        List<Long> listProductIds = new ArrayList<>(setProductId);
        List<ProductModel> products = productRepository.findAllById(listProductIds);

        Map<Long, Long> mapPrice = new HashMap<>();
        products.forEach(p -> mapPrice.put(p.getId(), p.getPrice()));
        Map<Long, Integer> mapNumber = new HashMap<>();
        products.forEach(p -> mapNumber.put(p.getId(), p.getNumber()));

        AtomicReference<Long> total = new AtomicReference<>((long) 0);
        req.getOrders().forEach(i ->
        {
            if (!mapPrice.containsKey(i.getProductId())) {
                String msg = String.format("product id not found, id:%s", i.getProductId());
                throw BadRequestException.WithMessage(msg);
            }
            if (mapNumber.get(i.getProductId()) < i.getNumber()) {
                String msg = String.format("number product is not enough, id:%s", i.getProductId());
                throw BadRequestException.WithMessage(msg);
            }
            total.updateAndGet(v -> v + i.getNumber() * mapPrice.get(i.getProductId()));
        });
        return total.get();
    }


}
