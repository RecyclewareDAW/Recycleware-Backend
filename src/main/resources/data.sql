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

-- Estados de la donación registrada
INSERT INTO estados_donacion (nombre) VALUES 
('Pendiente'), 
('En Recogida'), 
('Recibido'), 
('Procesado');

-- Usuarios de prueba (contraseña: 123456789 o 987654321)
INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, provincia, codigo_postal, rol)
VALUES ('Admin', '12345678X', '600111222', 'admin@recycleware.com', '12345678', 'Calle Falsa 123', 'Alicante', '03001', 'ADMIN');
INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, provincia, codigo_postal, razon_social, nombre_contacto, rol)
VALUES ('Empresa', '12345635X', '600111222', 'empresa@recycleware.com', '12345678', 'Calle empresa 10', 'Alicante', '03001', 'Recycleware SL', 'Recycle', 'EMPRESA');
INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, provincia, codigo_postal, rol)
VALUES ('Particular', '12345675X', '600111222', 'particular@ejemplo.com', '987654321', 'Calle Balmis 45', 'Alicante', '03001', 'PARTICULAR');

-- Productos
INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Ratón Acer OMW', 1, 1, 1, 'Ratón apenas usado con dos botones laterales y boton de cambio de DPI', 'https://placehold.co/600x400/orange/white');