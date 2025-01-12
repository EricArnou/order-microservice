package com.gmail.ericarnou68.ordermicroservice.service;

import com.gmail.ericarnou68.ordermicroservice.controller.ReturnOrderDetailsDto;
import com.gmail.ericarnou68.ordermicroservice.entity.OrderEntity;
import com.gmail.ericarnou68.ordermicroservice.listener.OrderEventDto;
import com.gmail.ericarnou68.ordermicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder(OrderEventDto orderEventDto){
        orderRepository.save(new OrderEntity(orderEventDto));
    }

    public ResponseEntity<Page<ReturnOrderDetailsDto>> getCustomerOrdersDetails(Long customerId, Pageable pageable) {
        var page = orderRepository.findAllByCustomerId(customerId, pageable)
                .map(ReturnOrderDetailsDto::new);
        return ResponseEntity.ok(page);
    }
}
