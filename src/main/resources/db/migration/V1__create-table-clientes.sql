create table clientes(
                id bigint not null auto_increment,
                nombre varchar(100) not null,
                email varchar(100) not null unique,
                tipo_documento varchar(100) not null,
                documento varchar(12) not null unique,
                direccion varchar(100)not null,
                activo TINYINT,
                fecha_de_creacion DATE NOT NULL,
                fecha_de_modificacion DATE,

                primary key(id)

);