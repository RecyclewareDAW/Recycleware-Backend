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

-- Usuarios de prueba (contraseña: 123456789 o 987654321)
INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, rol)
VALUES ('Admin', '12345678X', '600111222', 'admin@recycleware.com', '12345678', 'Calle Falsa 123', 'Alicante', '03001', 'ADMIN');
INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, razon_social, nombre_contacto, rol)
VALUES ('Empresa', '12345635X', '600111222', 'empresa@recycleware.com', '12345678', 'Calle empresa 10', 'Alicante', '03001', 'Recycleware SL', 'Recycle', 'EMPRESA');
INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, rol)
VALUES ('Particular', '12345675X', '600111222', 'particular@ejemplo.com', '987654321', 'Calle Balmis 45', 'Alicante', '03001', 'PARTICULAR');

-- Productos
INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Ratón Acer OMW', 1, 1, 1, 'Ratón apenas usado con dos botones laterales y boton de cambio de DPI', 'https://placehold.co/600x400/orange/white');

-- Estados de donaciones
INSERT INTO estados_donacion (id, nombre) VALUES (1, 'Pendiente');
INSERT INTO estados_donacion (id, nombre) VALUES (2, 'En Recogida');
INSERT INTO estados_donacion (id, nombre) VALUES (3, 'Recibido');
INSERT INTO estados_donacion (id, nombre) VALUES (4, 'Procesado');

-- Donaciones de prueba

INSERT INTO donaciones (id_donante, id_estado, cantidad_productos, descripcion, peso, volumen)
VALUES (1, 1, 5, 'Lote de monitores antiguos', 15.5, 0.8);
INSERT INTO donaciones (id_donante, id_estado, cantidad_productos, descripcion, peso, volumen)
VALUES (3, 2, 2, 'Servidor de rack para desguace', 40.0, 1.2);
INSERT INTO donaciones (id_donante, id_estado, cantidad_productos, descripcion, peso, volumen)
VALUES (1, 3, 10, 'Caja con teclados y ratones varios', 5.0, 0.3);
INSERT INTO donaciones (id_donante, id_estado, cantidad_productos, descripcion, peso, volumen)
VALUES (null, 3, 10, 'Caja con teclados y ratones varios', 5.0, 0.3);