CREATE TABLE bodegas (
                         id BIGINT AUTO_INCREMENT,
                         nombre VARCHAR(255) NOT NULL,
                         direccion VARCHAR(255) NOT NULL,
                         ciudad VARCHAR(100) NOT NULL,
                         estado VARCHAR(100) NOT NULL,
                         pais VARCHAR(100) NOT NULL,
                         codigo_postal VARCHAR(20) NOT NULL,
                         capacidad_almacenamiento DOUBLE NOT NULL,
                         capacidad_disponible DOUBLE NOT NULL,
                         responsable VARCHAR(100),
                         telefono_contacto VARCHAR(20),
                         email_contacto VARCHAR(100),
                         tipo_bodega varchar(100) NOT NULL,
                         fecha_de_creacion DATE NOT NULL,
                         fecha_de_modificacion DATE,

                         primary key(id)


)ENGINE=InnoDB;