package com.backend.backend.domain.bodega;

import com.backend.backend.domain.base.Base;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "bodegas")
@Entity(name = "bodega")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Builder
public class Bodega extends Base {
    @Column (unique = true, nullable = false)
    private String nombre;
    private String direccion;
    private String ciudad;
    private String estado;
    private String pais;
    private String codigoPostal;
    private BigDecimal capacidadAlmacenamiento;
    private BigDecimal capacidadDisponible;
    private String responsable;
    private String telefonoContacto;
    private String emailContacto;
    @Enumerated(EnumType.STRING)
    private TipoBodega tipoBodega;
}
