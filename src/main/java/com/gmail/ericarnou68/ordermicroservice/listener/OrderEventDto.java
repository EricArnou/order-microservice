package com.gmail.ericarnou68.ordermicroservice.listener;


import java.util.List;

public record OrderEventDto(Long codigoPedido, Long codigoCliente, List<OrderItemEventDto> itens)  {
}
