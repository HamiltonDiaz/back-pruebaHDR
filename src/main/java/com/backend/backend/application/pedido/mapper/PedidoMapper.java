package com.backend.backend.application.pedido.mapper;

import com.backend.backend.application.pedido.dto.PedidoDTO;
import com.backend.backend.domain.pedido.Pedido;

public class PedidoMapper {
    public static Pedido toPedido(PedidoDTO pedidoDTO) {
        return Pedido.builder()
                .cantidadProducto(pedidoDTO.cantidadProducto())
                .precioDeEnvio(pedidoDTO.precioDeEnvio())
                .idetentificacionVehiculo(pedidoDTO.idetentificacionVehiculo())
                .build();
    }
}
