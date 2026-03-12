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

-- Disponibilidad de producto
INSERT INTO disponibilidad_producto (nombre) VALUES ('Disponible');
INSERT INTO disponibilidad_producto (nombre) VALUES ('Reservado');

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
INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Ratón Acer OMW', 1, 1, 1, 'Ratón apenas usado con dos botones laterales y boton de cambio de DPI', 'https://placehold.co/600x400/orange/white');