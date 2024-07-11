package com.backend.backend.application.producto.service;

import com.backend.backend.application.producto.dto.ProductoDTO;
import com.backend.backend.domain.producto.Producto;

public interface IProductoService {
    Producto createProducto(ProductoDTO productoDTO);
    Producto getProducto(Long id);
}
