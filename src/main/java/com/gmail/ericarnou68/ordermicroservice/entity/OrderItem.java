package com.gmail.ericarnou68.ordermicroservice.entity;

import com.gmail.ericarnou68.ordermicroservice.listener.OrderItemEventDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    private String product;
    private Integer quantity;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal price;

    public OrderItem(OrderItemEventDto orderItemEventDto) {
        this.product = orderItemEventDto.produto();
        this.price = orderItemEventDto.preco();
        this.quantity = orderItemEventDto.quantidade();
    }
}
