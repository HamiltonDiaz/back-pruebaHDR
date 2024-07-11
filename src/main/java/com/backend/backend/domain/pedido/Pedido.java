package com.backend.backend.domain.pedido;

import com.backend.backend.domain.base.Base;
import com.backend.backend.domain.bodega.Bodega;
import com.backend.backend.domain.cliente.Cliente;
import com.backend.backend.domain.producto.Producto;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Table(name = "pedidos")
@Entity(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Builder
public class Pedido extends Base {
    private BigInteger cantidadProducto;
    private LocalDate fechaDeEntrega;
    private BigDecimal precioDeEnvio;
    private BigDecimal precioFinal;
    private String idetentificacionVehiculo;
    private String numeroDeGuia;

    @ManyToOne
    @JoinColumn(name = "bodega_id")
    private Bodega bodega;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
