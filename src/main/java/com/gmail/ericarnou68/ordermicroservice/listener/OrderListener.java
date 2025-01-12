package com.gmail.ericarnou68.ordermicroservice.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static com.gmail.ericarnou68.ordermicroservice.config.RabbitMqConfig.ORDER_CREATED_QUEUE;

@Component
public class OrderListener {

    private final Logger logger = LoggerFactory.getLogger(OrderListener.class);

    @RabbitListener(queues = ORDER_CREATED_QUEUE)
    public void listen(Message<OrderEventDto> message) {
        logger.info("Received order event: {}", message);
    }
}
