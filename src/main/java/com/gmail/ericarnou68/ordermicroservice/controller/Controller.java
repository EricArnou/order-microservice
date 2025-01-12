package com.gmail.ericarnou68.ordermicroservice.controller;

import com.gmail.ericarnou68.ordermicroservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private OrderService orderService;

    @GetMapping("/customers/{customerId}/orders")
    public ResponseEntity<Page<ReturnOrderDetailsDto>> getCustomerOrdersDetails(@PathVariable("customerId") Long customerId, Pageable pageable) {
        return orderService.getCustomerOrdersDetails(customerId, pageable);
    }
}