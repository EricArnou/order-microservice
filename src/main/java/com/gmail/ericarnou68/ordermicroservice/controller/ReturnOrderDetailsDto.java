package com.gmail.ericarnou68.ordermicroservice.controller;

import com.gmail.ericarnou68.ordermicroservice.entity.OrderEntity;

import java.math.BigDecimal;

public record ReturnOrderDetailsDto(Long orderId, Long customerId, BigDecimal total) {

    public ReturnOrderDetailsDto(OrderEntity orderEntity){
        this(orderEntity.getOrderId(), orderEntity.getCustomerId(), orderEntity.getTotal());
    }
}
