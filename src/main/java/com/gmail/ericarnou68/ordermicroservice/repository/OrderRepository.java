package com.gmail.ericarnou68.ordermicroservice.repository;

import com.gmail.ericarnou68.ordermicroservice.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity, Integer> {
    Page<OrderEntity> findAllByCustomerId(Long customerId, Pageable pageable);
}
