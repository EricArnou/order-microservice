package com.gmail.ericarnou68.ordermicroservice.service;

import com.gmail.ericarnou68.ordermicroservice.entity.OrderEntity;
import com.gmail.ericarnou68.ordermicroservice.listener.OrderEventDto;
import com.gmail.ericarnou68.ordermicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void saveOrder(OrderEventDto orderEventDto){
        orderRepository.save(new OrderEntity(orderEventDto));
    }
}
