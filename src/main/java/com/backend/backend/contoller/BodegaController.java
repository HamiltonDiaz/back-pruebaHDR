package com.backend.backend.contoller;

import com.backend.backend.application.bodega.dto.BodegaDTO;
import com.backend.backend.application.bodega.dto.RespuestaBodegaDTO;
import com.backend.backend.application.bodega.service.IBodegaService;
import com.backend.backend.domain.bodega.Bodega;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/bodegas")
public class BodegaController {

    @Autowired
    private IBodegaService service;

    @PostMapping
    public ResponseEntity <RespuestaBodegaDTO> addBodega(@RequestBody @Valid BodegaDTO bodegaDTO,
                                                         UriComponentsBuilder uriBuilder) {
        Bodega bodega = service.createBodega(bodegaDTO);
        RespuestaBodegaDTO respuestaBodegaDTO = new RespuestaBodegaDTO(bodega);
        URI url= uriBuilder.path("/api/v1/bodegas/{id}").buildAndExpand(bodega.getId()).toUri();
        return ResponseEntity.created(url).body(respuestaBodegaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaBodegaDTO> getBodega(@PathVariable Long id) {
        Bodega bodega = service.getBodega(id);
        return ResponseEntity.ok(new RespuestaBodegaDTO(bodega));
    }


}
