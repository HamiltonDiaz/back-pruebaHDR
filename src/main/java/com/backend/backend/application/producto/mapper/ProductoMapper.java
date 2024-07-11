package com.backend.backend.application.producto.mapper;

import com.backend.backend.application.producto.dto.ProductoDTO;
import com.backend.backend.domain.producto.Producto;

public class ProductoMapper {
    public static Producto mapProducto(ProductoDTO productoDTO) {
        Producto producto = Producto.builder()
                .nombre(productoDTO.nombre())
                .descripcion(productoDTO.descripcion())
                .categoriaProducto(productoDTO.categoriaProducto())
                .build();
        return producto;
    }
}
