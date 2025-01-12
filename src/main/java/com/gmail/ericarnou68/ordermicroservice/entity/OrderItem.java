package com.gmail.ericarnou68.ordermicroservice.entity;

import com.gmail.ericarnou68.ordermicroservice.listener.OrderItemEventDto;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import java.math.BigDecimal;

public class OrderItem {

    private String product;
    private Integer quantity;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal price;

    public OrderItem() {}

    public OrderItem(OrderItemEventDto orderItemEventDto) {
        this.product = orderItemEventDto.produto();
        this.price = orderItemEventDto.preco();
        this.quantity = orderItemEventDto.quantidade();
    }
}
