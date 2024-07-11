create table productos(
                id bigint not null auto_increment,
                nombre varchar(100) not null unique,
                descripcion varchar(255) not null,
                categoria_producto varchar(100) not null,
                activo TINYINT,
                fecha_de_creacion DATE NOT NULL,
                fecha_de_modificacion DATE,

                primary key(id)

)ENGINE=InnoDB;