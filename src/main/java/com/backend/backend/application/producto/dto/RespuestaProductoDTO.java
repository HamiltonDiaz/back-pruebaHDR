package com.backend.backend.application.producto.dto;

import com.backend.backend.domain.producto.Producto;
import jakarta.validation.constraints.NotBlank;

public record RespuestaProductoDTO(
        Long id ,
        String nombre,
        String descripcion,
        String categoria
) {
    public RespuestaProductoDTO (Producto producto) {
        this(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getCategoriaProducto().name()
        );
    }
}
