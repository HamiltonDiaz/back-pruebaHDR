package com.backend.backend.application.pedido.dto;

import com.backend.backend.application.bodega.dto.RespuestaBodegaPedidoDTO;
import com.backend.backend.application.cliente.dto.RespuestaClienteDTO;
import com.backend.backend.application.producto.dto.RespuestaProductoDTO;
import com.backend.backend.domain.pedido.Pedido;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;


public record RespuestaPedidoDTO(
        Long id,
        BigInteger cantidadProducto,
        LocalDate fechaDeEntrega,
        BigDecimal precioDeEnvio,
        BigDecimal precioFnal,
        String idetentificacionVehiculo,
        String numeroDeguia,
        LocalDate fechaDeCreacion,
        RespuestaProductoDTO producto,
        RespuestaClienteDTO cliente,
        RespuestaBodegaPedidoDTO bodega

) {
    public RespuestaPedidoDTO(Pedido pedido) {
        this(
                pedido.getId(),
                pedido.getCantidadProducto(),
                pedido.getFechaDeEntrega(),
                pedido.getPrecioDeEnvio(),
                pedido.getPrecioFinal(),
                pedido.getIdetentificacionVehiculo(),
                pedido.getNumeroDeGuia(),
                pedido.getFechaDeCreacion(),
                new RespuestaProductoDTO(pedido.getProducto()),
                new RespuestaClienteDTO(pedido.getCliente()),
                new RespuestaBodegaPedidoDTO(pedido.getBodega())
        );
    }
}
