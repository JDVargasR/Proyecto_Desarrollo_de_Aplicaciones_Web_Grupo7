/*Se crea la base de datos */
drop schema if exists progra;
drop user if exists usuario_prueba;
CREATE SCHEMA progra;

/*Se crea un usuario para la base de datos llamado "usuario_prueba" y tiene la contraseña "Usuario_Clave."*/
create user 'usuario_prueba'@'%' identified by 'Usuar1o_Clave.';

/*Se asignan los prvilegios sobr ela base de datos TechShop al usuario creado */
grant all privileges on progra.* to 'usuario_prueba'@'%';
flush privileges;

use progra;

-----------------------------------------------------------------


CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    correo VARCHAR(100),
    username VARCHAR(50) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE rol (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50)
);

/*creamos los roles disponibles*/
INSERT INTO rol (id, nombre) VALUES (1, 'USER');
INSERT INTO rol (id, nombre) VALUES (2, 'ADMIN');


CREATE TABLE usuario_rol (
    usuario_id BIGINT,
    rol_id BIGINT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (rol_id) REFERENCES rol(id),
    PRIMARY KEY (usuario_id, rol_id)
);

INSERT INTO usuario (nombre, correo, username, password)
VALUES (
  'josue',
  'prueba@email.com',
  'josue',
  '$2a$10$xaaReEFEh8.ulnY5QIKwFeTnaWcLmY7Zc128wdKq3jcOjcer1Sf92'
);
INSERT INTO usuario (nombre, correo, username, password)
VALUES (
'Administrador',
 'admin@email.com',
 'admin',
 '$2a$10$xaaReEFEh8.ulnY5QIKwFeTnaWcLmY7Zc128wdKq3jcOjcer1Sf92'
 );

-- Le asignás el rol USER
INSERT INTO usuario_rol (usuario_id, rol_id)
VALUES (1, 1); -- Asumiendo que el usuario creado tiene ID = 1
-- Le asignás el rol admin
INSERT INTO usuario_rol (usuario_id, rol_id)
VALUES (2, 2);
--------------------------------------------------------------------


/* la tabla de categoria contiene categorias de productos*/
create table imagenes (
  id_imagen INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(30) NOT NULL,
  ruta_imagen varchar(1024),
  activo bool,
  PRIMARY KEY (id_imagen))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE preguntas_frecuentes (
  id_pregunta INT NOT NULL AUTO_INCREMENT,
  pregunta VARCHAR(255) NOT NULL,
  respuesta TEXT NULL,
  activo BOOLEAN,
  PRIMARY KEY (id_pregunta)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE habitacion (
  id_habitacion INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(255) NOT NULL,
  ruta_imagen varchar(1024),
  activo BOOLEAN,
  PRIMARY KEY (id_habitacion)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;



CREATE TABLE blog (
    id_blog INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT NOT NULL,
    contenido TEXT,
    imagen_url VARCHAR(1024),
    activo BOOLEAN,
    PRIMARY KEY (id_blog)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;



CREATE TABLE contacto (
  id_contacto INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  correo VARCHAR(75) NOT NULL,
  telefono VARCHAR(15) NULL,
  mensaje TEXT NOT NULL,
  fecha_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  activo boolean,
  PRIMARY KEY (id_contacto)
)  ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE detalle_cabina (
	id_detalle_cabina INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT NOT NULL,
    precio DOUBLE,
    ruta_imagen VARCHAR(1024),
    activo BOOLEAN,
    galeria_imagenes TEXT,
    PRIMARY KEY (id_detalle_cabina)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;


select * from detalle_cabina;
CREATE TABLE reserva (
  id_reserva INT NOT NULL AUTO_INCREMENT,
  fecha_entrada DATE NOT NULL,
  fecha_salida DATE NOT NULL,
  personas INT NOT NULL,
  id_detalle_cabina INT NOT NULL,
  PRIMARY KEY (id_reserva),
  FOREIGN KEY (id_detalle_cabina) REFERENCES detalle_cabina(id_detalle_cabina)
    ON DELETE CASCADE
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE pago (
  id_pago INT NOT NULL AUTO_INCREMENT,
  nombre_tarjeta VARCHAR(100),
  numero_tarjeta VARCHAR(20),
  codigo_seguridad VARCHAR(10),
  mes VARCHAR(10),
  anio VARCHAR(10),
  id_reserva INT,
  PRIMARY KEY (id_pago),
  FOREIGN KEY (id_reserva) REFERENCES reserva(id_reserva)
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE energias_renovables (
 id_energias_renovables INT NOT NULL AUTO_INCREMENT,
 titulo VARCHAR(50),
 descripcion VARCHAR(100),
 imagen_url varchar(1024),
 PRIMARY KEY (id_energias_renovables)
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;



INSERT INTO energias_renovables (titulo, descripcion, imagen_url) VALUES
('Energía Solar',
 'Instalamos paneles solares en el techo de nuestras cabinas para reducir el consumo eléctrico.',
 '/Imgs/ImagenesEnergiasRenovables/energia1.jpg'),
 
('Recolección de agua de lluvia',
 'Usamos sistemas de captación y filtrado para aprovechar el agua de lluvia.',
 '/Imgs/ImagenesEnergiasRenovables/energia2.jpg');
 
 UPDATE energias_renovables
SET imagen_url = '/Img''s/imgs/energias/energia1.jpg'
WHERE id_energias_renovables = 1;

UPDATE energias_renovables
SET imagen_url ='/Img''s/imgs/energias/energia2.jpg'
WHERE id_energias_renovables = 2;
 


INSERT INTO detalle_cabina (nombre, descripcion, precio, ruta_imagen, activo) VALUES
-- Cabina 5
('Cabina 5', 'Cama matrimonial, baño y balcón.', 20000, '/img/cabina5.jpg', true),

-- Cabina 6
('Cabina 6', 'Cama matrimonial, cama individual, baño y cocina semi equipada, balcón.', 30000, '/img/cabina6.jpg', true),

-- Cabina 7
('Cabina 7', 'Cocina semi equipada, dos habitaciones, dos baños y balcón.', 40000, '/img/cabina7.jpg', true),

-- Villa Familiar
('Villa Familiar', 'Sala, cocina equipada, habitación King, habitación doble, baño completo.', 60000, '/img/villa.jpg', true),

-- Casa Familiar
('Casa Familiar', 'Casa completa equipada, 10 personas, parqueo amplio.', 120000, '/img/casa.jpg', true),

-- Estudio
('Estudio', 'Cama queen, jacuzzi, cocina semi equipada y terraza.', 50000, '/img/estudio.jpg', true);

 
UPDATE detalle_cabina 
SET galeria_imagenes = '/Img''s/Imagenes Home/section habitaciones/cabina5_1.jpg,/Img''s/Imagenes Home/section habitaciones/cabina5_2.jpg,/Img''s/Imagenes Home/section habitaciones/cabina5_3.jpg,/Img''s/Imagenes Home/section habitaciones/cabina5_4.jpg,/Img''s/Imagenes Home/section habitaciones/cabina5_5.jpg' 
WHERE id_detalle_cabina = 1;

UPDATE detalle_cabina 
SET galeria_imagenes = '/Img''s/Imagenes Home/section habitaciones/cabina6_1.jpg,/Img''s/Imagenes Home/section habitaciones/cabina6_2.jpg,/Img''s/Imagenes Home/section habitaciones/cabina6_3.jpg,/Img''s/Imagenes Home/section habitaciones/cabina6_4.jpg,/Img''s/Imagenes Home/section habitaciones/cabina6_5.jpg' 
WHERE id_detalle_cabina = 2;

UPDATE detalle_cabina 
SET galeria_imagenes = '/Img''s/Imagenes Home/section habitaciones/cabina7_1.jpg,/Img''s/Imagenes Home/section habitaciones/cabina7_2.jpg,/Img''s/Imagenes Home/section habitaciones/cabina7_3.jpg,/Img''s/Imagenes Home/section habitaciones/cabina7_4.jpg,/Img''s/Imagenes Home/section habitaciones/cabina7_5.jpg' 
WHERE id_detalle_cabina = 3;

UPDATE detalle_cabina 
SET galeria_imagenes = '/Img''s/Imagenes Home/section habitaciones/villa_1.jpg,/Img''s/Imagenes Home/section habitaciones/villa_2.jpg,/Img''s/Imagenes Home/section habitaciones/villa_3.jpg,/Img''s/Imagenes Home/section habitaciones/villa_4.jpg,/Img''s/Imagenes Home/section habitaciones/villa_5.jpg' 
WHERE id_detalle_cabina = 4;

UPDATE detalle_cabina 
SET galeria_imagenes = '/Img''s/Imagenes Home/section habitaciones/casa_1.jpg,/Img''s/Imagenes Home/section habitaciones/casa_2.jpg,/Img''s/Imagenes Home/section habitaciones/casa_3.jpg,/Img''s/Imagenes Home/section habitaciones/casa_4.jpg,/Img''s/Imagenes Home/section habitaciones/casa_5.jpg' 
WHERE id_detalle_cabina = 5;

UPDATE detalle_cabina 
SET galeria_imagenes = '/Img''s/Imagenes Home/section habitaciones/estudio_1.jpg,/Img''s/Imagenes Home/section habitaciones/estudio_2.jpg,/Img''s/Imagenes Home/section habitaciones/estudio_3.jpg,/Img''s/Imagenes Home/section habitaciones/estudio_4.jpg,/Img''s/Imagenes Home/section habitaciones/estudio_5.jpg' 
WHERE id_detalle_cabina = 6;

INSERT INTO preguntas_frecuentes (pregunta, respuesta, activo) VALUES
('¿De cuántas personas es la casa familiar?', 'Es para 10 personas.', true),
('¿Cuánto es el precio del estudio por pareja?', 'Contamos con los precios de 45.000 y con desayuno 50.000.', true),
('¿Dónde se encuentran ubicados?', 'Nos encontramos en un pueblito llamado San Lorenzo de Tarrazú.', true),
('¿Aceptan Mascotas?', 'Sí, tenemos diferentes habitaciones donde está permitido.', true),
('¿Precio de la cabina 6 para una persona?', 'El precio es de 20.000 para una persona y con desayuno 25.000.', true);



