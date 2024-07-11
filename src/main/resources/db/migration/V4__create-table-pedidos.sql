CREATE TABLE pedidos (
                         id bigint AUTO_INCREMENT,
                         cantidad_producto INT not null,
                         fecha_de_entrega DATE NOT NULL,
                         precio_de_envio DOUBLE NOT NULL,
                         precio_final DOUBLE NOT NULL,
                         idetentificacion_vehiculo VARCHAR(10) NOT NULL,
                         numero_de_guia VARCHAR(20) NOT NULL,
                         fecha_de_creacion DATE NOT NULL,
                         fecha_de_modificacion DATE,
                         cliente_id bigint not null,
                         producto_id bigint not null,
                         bodega_id bigint not null,

                         primary key(id),
                         CONSTRAINT fk_pedidos_cliente_id FOREIGN KEY (cliente_id) REFERENCES clientes(id),
                         CONSTRAINT fk_pedidos_producto_id FOREIGN KEY (producto_id) REFERENCES productos(id),
                         CONSTRAINT fk_pedidos_bodega_id FOREIGN KEY (bodega_id) REFERENCES bodegas(id)
)ENGINE=InnoDB;