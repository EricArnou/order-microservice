package com.gmail.ericarnou68.ordermicroservice.entity;

import com.gmail.ericarnou68.ordermicroservice.listener.OrderEventDto;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import java.math.BigDecimal;
import java.util.List;

@Document(collection = "tb_orders")
public class OrderEntity {

    @MongoId
    private Long orderId;

    @Indexed(name = "customer_id_index")
    private Long customerId;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal total;

    private List<OrderItem> orderitemsList;

    public OrderEntity(){

    }

    public OrderEntity(OrderEventDto orderEventDto) {
        this.orderId = orderEventDto.codigoPedido();
        this.customerId = orderEventDto.codigoCliente();

        this.orderitemsList = orderEventDto.itens().stream()
                .map(OrderItem::new)
                .toList();

        this.total = orderEventDto.itens().stream()
                .map(i -> i.preco().multiply(BigDecimal.valueOf(i.quantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
