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

-- Usuarios de prueba (contraseña: 1234 para todo (hasheada))
INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, rol)
VALUES ('Admin', '12345678X', '600111222', 'admin@recycleware.com', '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'Calle Falsa 123', 'Alicante', '03001', 'ADMIN');
INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, razon_social, nombre_contacto, rol)
VALUES ('Empresa', '12345635X', '600111222', 'empresa@recycleware.com', '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'Calle empresa 10', 'Alicante', '03001', 'Recycleware SL', 'Recycle', 'EMPRESA');
INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, rol)
VALUES ('Particular', '12345675X', '600111222', 'particular@ejemplo.com', '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'Calle Balmis 45', 'Alicante', '03001', 'PARTICULAR');

INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, rol)
VALUES ('Bela', '12345645X', '600111222', 'bela@particular.com', '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'Calle Balmis 45', 'Alicante', '03001', 'PARTICULAR');

INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, razon_social, nombre_contacto, rol)
VALUES ('Empresa Bela', '72345635X', '600111222', 'bela@empresa.com', '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'Calle empresa 10', 'Alicante', '03001', 'Empresa de Bela', 'Ree', 'EMPRESA');

INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, rol)
VALUES ('Bela', '19345675X', '600111222', 'bela@admin.com', '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'Calle Balmis 45', 'Alicante', '03001', 'ADMIN');

INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, razon_social, nombre_contacto, rol)
VALUES ('Bela emproesa 2', '12345935X', '600111222', 'bela@empresa2.com', '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'Calle empresa 10', 'Alicante', '03001', 'Otra emporesa', 'Recycle', 'EMPRESA');

INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, razon_social, nombre_contacto, rol)
VALUES ('Bela emproesa 3', '12345035X', '600111222', 'bela@empresa3.com', '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'Calle empresa 10', 'Alicante', '03001', 'Una empresa terceera', 'Recycle', 'EMPRESA');

INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, razon_social, nombre_contacto, rol)
VALUES ('Bela emproesa 4', '12355035X', '600111222', 'bela@empresa4.com', '$2a$10$ayw3FCBIkupFt5n9lrmJQe9XZMJhZiNCjaoOkXo/Ba0KZgymO01ce', 'Calle empresa 10', 'Alicante', '03001', 'Una empresa cuarta', 'Recycle', 'EMPRESA');


------------------------------------------------------
-- Productos------------------------------------------
------------------------------------------------------
    
    -- Periféricos
INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Ratón Mars', 1, 2, 1, 'Ratón gastado con dos botones laterales y boton de cambio de DPI', 'https://placehold.co/600x400/orange/white');

INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Ratón inalambrico Logitec', 1, 2, 1, 'Ratón inalambrico con usb independiente con 2 botones laterales y poco rango de conexión', 'https://placehold.co/600x400/green/white');

    
    -- Sobremesa
INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Torre Artec netanya', 3, 1, 1, 'Core I5 8RAM 1TB hhd y lector de Dvd', 'https://thumb.pccomponentes.com/w-530-530/articles/1083/10837879/1830-pcgam-oficina-madrid-slim-intel-core-i3-10100-16gb-500gb-ssd.jpg');

INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Torre dañada Nox', 3, 4, 1, 'Torre rota que se desconoce por que no arranca y antiguo', 'https://placehold.co/400x600/red/black');

    
    -- Componentes
INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Procesador Intel i7-6700K', 4, 1, 2, 'Procesador con apenas uso', 'https://placehold.co/600x600/blue/white');

INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('GPU Sapphire Radeon HD 5570', 4, 2, 1, 'Tarjeta gráfica con varios años de uso pero todavía funcional ni indicios de estropearse', 'https://placehold.co/600x400/red/black');

    
    -- Monitores
INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Monitor Dell P2212', 5, 1, 1, 'Monitor Dell de una oficinia que pese al uso esta en buen estado todavía', 'https://placehold.co/600x600/blue/white');

INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Monitor VSDISPLAY LCD', 5, 3, 1, 'Monitor con 3 franjas verticales negras pero todavia funcional', 'https://placehold.co/600x400/red/black');

    
    -- Portatiles
INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Dell Inspiron', 2, 3, 1, '8Gb Ram 120Gb Hdd. Pantalla dañada por un golpe pero el resto del dispositivo funciona correctamente', 'https://placehold.co/600x600/blue/white');

INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Lenovo G500s', 2, 1, 1, '8Gb Ram 320Gb Hdd y webcam integrada', 'https://placehold.co/600x400/red/black');



-- Estados de donaciones
INSERT INTO estados_donacion (id, nombre) VALUES (1, 'Pendiente');
INSERT INTO estados_donacion (id, nombre) VALUES (2, 'En Recogida');
INSERT INTO estados_donacion (id, nombre) VALUES (3, 'Recibido');
INSERT INTO estados_donacion (id, nombre) VALUES (4, 'Procesado');

-- Donaciones de prueba

INSERT INTO donaciones (id_donante, id_estado, cantidad_productos, descripcion, peso)
VALUES (1, 1, 5, 'Lote de monitores antiguos', 15.5);
INSERT INTO donaciones (id_donante, id_estado, cantidad_productos, descripcion, peso)
VALUES (3, 2, 2, 'Servidor de rack para desguace', 40.0);
INSERT INTO donaciones (id_donante, id_estado, cantidad_productos, descripcion, peso)
VALUES (1, 3, 10, 'Caja con teclados y ratones varios', 5.0);
INSERT INTO donaciones (id_donante, id_estado, cantidad_productos, descripcion, peso)
VALUES (null, 3, 10, 'Caja con teclados y ratones varios', 5.0);

-- Donación para el usuario 2 (Recycleware SL - Rol: EMPRESA)
INSERT INTO donaciones (id_donante, id_estado, cantidad_productos, descripcion, peso)
VALUES (2, 3, 50, 'Donación de prueba Empresa A', 10.0);

-- Donación para el usuario 5 (Bela - Rol: EMPRESA)
INSERT INTO donaciones (id_donante, id_estado, cantidad_productos, descripcion, peso)
VALUES (5, 3, 30, 'Donación de prueba Empresa B', 5.0);