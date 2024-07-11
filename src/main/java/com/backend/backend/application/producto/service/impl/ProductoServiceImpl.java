package com.backend.backend.application.producto.service.impl;

import com.backend.backend.application.producto.dto.ProductoDTO;
import com.backend.backend.application.producto.mapper.ProductoMapper;
import com.backend.backend.application.producto.service.IProductoService;
import com.backend.backend.domain.contans.MessageApplication;
import com.backend.backend.domain.producto.Producto;
import com.backend.backend.domain.producto.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto createProducto(ProductoDTO productoDTO) {
        if (productoRepository.findByNombre(productoDTO.nombre()).isEmpty()) {
            Producto saveProducto= ProductoMapper.mapProducto(productoDTO);
            saveProducto.setActivo(true);
            saveProducto.setFechaDeCreacion(LocalDate.now());

            return productoRepository.save(saveProducto);
        }else {
            throw new RuntimeException(MessageApplication.DUPLICATE);
        }
    }

    @Override
    public Producto getProducto(Long id) {
        if (productoRepository.findById(id).isPresent()) {
            return productoRepository.getReferenceById(id);
        }else {
            throw new RuntimeException(MessageApplication.NOTFOUND);
        }
    }
}
