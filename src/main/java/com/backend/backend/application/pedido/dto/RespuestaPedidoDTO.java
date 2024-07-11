package com.backend.backend.application.pedido.dto;

import com.backend.backend.application.bodega.dto.RespuestaBodegaDTO;
import com.backend.backend.application.cliente.dto.RespuestaClienteDTO;
import com.backend.backend.application.producto.dto.RespuestaProductoDTO;
import com.backend.backend.domain.pedido.Pedido;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public record RespuestaPedidoDTO(
        BigInteger cantidadProducto,
        LocalDate fechaDeEntrega,
        BigDecimal precioDeEnvio,
        String idetentificacionVehiculo,
        String numeroDeguia,
        LocalDate fechaDeCreacion,
        RespuestaProductoDTO productoDTO,
        RespuestaClienteDTO clienteDTO,
        RespuestaBodegaDTO bodegaDTO
) {
    public RespuestaPedidoDTO(Pedido pedido) {
        this(
                pedido.getCantidadProducto(),
                pedido.getFechaDeEntrega(),
                pedido.getPrecioDeEnvio(),
                pedido.getIdetentificacionVehiculo(),
                pedido.getNumeroDeGuia(),
                pedido.getFechaDeCreacion(),
                new RespuestaProductoDTO(pedido.getProducto()),
                new RespuestaClienteDTO(pedido.getCliente()),
                new RespuestaBodegaDTO(pedido.getBodega())
        );
    }
}
