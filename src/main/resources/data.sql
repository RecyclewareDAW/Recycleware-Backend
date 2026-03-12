-- Datos iniciales para Recycleware

-- Categorías
INSERT INTO categorias_producto (nombre) VALUES ('Periféricos');
INSERT INTO categorias_producto (nombre) VALUES ('Portátiles');
INSERT INTO categorias_producto (nombre) VALUES ('Sobremesa');
INSERT INTO categorias_producto (nombre) VALUES ('Componentes');
INSERT INTO categorias_producto (nombre) VALUES ('Monitores');

-- Estados de los productos físicos
INSERT INTO estados_producto (nombre) VALUES ('Excelente');
INSERT INTO estados_producto (nombre) VALUES ('Funcional');
INSERT INTO estados_producto (nombre) VALUES ('Dañado');
INSERT INTO estados_producto (nombre) VALUES ('Para Piezas');

-- Estados de la gestión de solicitudes
INSERT INTO estados_solicitud (nombre) VALUES ('Pendiente');
INSERT INTO estados_solicitud (nombre) VALUES ('En Revisión');
INSERT INTO estados_solicitud (nombre) VALUES ('Aprobada');
INSERT INTO estados_solicitud (nombre) VALUES ('Denegada');
INSERT INTO estados_solicitud (nombre) VALUES ('Entregada');

-- Un usuario de prueba (contraseña: 1234)
INSERT INTO usuarios (nombre, dni, telefono, correo, contraseña, direccion, provincia, codigo_postal)
VALUES ('Admin', '12345678X', '600111222', 'admin@recycleware.com', '1234', 'Calle Falsa 123', 'Alicante', '03001');
INSERT INTO usuarios (nombre, dni, telefono, correo, contraseña, direccion, provincia, codigo_postal)
VALUES ('Admin2', '12345675X', '600111222', 'admin@recyclee.com', '1234', 'Calle Falsa 123', 'Alicante', '03001');
INSERT INTO usuarios (nombre, dni, telefono, correo, contraseña, direccion, provincia, codigo_postal, razon_social, nombre_contacto)
VALUES ('Bela', '12345635X', '600111222', 'bela@recyclee.com', '1234', 'Calle Falsa 123', 'Alicante', '03001', 'Belita SL', 'Yo');

-- Estados de donaciones
INSERT INTO estados_donacion (id, nombre) VALUES (1, 'Pendiente');
INSERT INTO estados_donacion (id, nombre) VALUES (2, 'En Recogida');
INSERT INTO estados_donacion (id, nombre) VALUES (3, 'Recibido');
INSERT INTO estados_donacion (id, nombre) VALUES (4, 'Procesado');

-- Donaciones de prueba

INSERT INTO donaciones (id_donante, id_estado, cantidad_productos, descripcion, peso, volumen)
VALUES (1, 1, 5, 'Lote de monitores antiguos', 15.5, 0.8);
INSERT INTO donaciones (id_donante, id_estado, cantidad_productos, descripcion, peso, volumen)
VALUES (1, 2, 2, 'Servidor de rack para desguace', 40.0, 1.2);
INSERT INTO donaciones (id_donante, id_estado, cantidad_productos, descripcion, peso, volumen)
VALUES (1, 3, 10, 'Caja con teclados y ratones varios', 5.0, 0.3);