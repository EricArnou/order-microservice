package com.gmail.ericarnou68.ordermicroservice.listener;

import java.math.BigDecimal;

public record OrderItemEventDto(String produto, Integer quantidade, BigDecimal preco) {
}
