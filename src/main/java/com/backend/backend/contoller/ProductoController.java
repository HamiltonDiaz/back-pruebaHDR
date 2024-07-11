package com.backend.backend.contoller;

import com.backend.backend.application.producto.dto.ProductoDTO;
import com.backend.backend.application.producto.dto.RespuestaProductoDTO;
import com.backend.backend.application.producto.service.IProductoService;
import com.backend.backend.domain.producto.Producto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private IProductoService service;

    @PostMapping
    public ResponseEntity <RespuestaProductoDTO> addCliente(@RequestBody @Valid ProductoDTO productoDTO,
                                                           UriComponentsBuilder uriBuilder) {
        Producto producto = service.createProducto(productoDTO);
        RespuestaProductoDTO respuestaProductoDTO = new RespuestaProductoDTO(producto);
        URI url= uriBuilder.path("/api/v1/productos/{id}").buildAndExpand(producto.getId()).toUri();
        return ResponseEntity.created(url).body(respuestaProductoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaProductoDTO> getProducto(@PathVariable Long id) {
        Producto producto = service.getProducto(id);
        return ResponseEntity.ok(new RespuestaProductoDTO(producto));
    }


}
