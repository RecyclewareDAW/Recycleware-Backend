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
INSERT INTO disponibilidad_producto (nombre) VALUES ('No Disponible');

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

INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, rol)
VALUES ('Bela', '12345645X', '600111222', 'bela@particular.com', '1234', 'Calle Balmis 45', 'Alicante', '03001', 'PARTICULAR');

INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, razon_social, nombre_contacto, rol)
VALUES ('Empresa Bela', '72345635X', '600111222', 'bela@empresa.com', '1234', 'Calle empresa 10', 'Alicante', '03001', 'Empresa de Bela', 'Ree', 'EMPRESA');

INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, rol)
VALUES ('Bela', '19345675X', '600111222', 'bela@admin.com', '1234', 'Calle Balmis 45', 'Alicante', '03001', 'ADMIN');

INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, razon_social, nombre_contacto, rol)
VALUES ('Bela emproesa 2', '12345935X', '600111222', 'bela@empresa2.com', '1234', 'Calle empresa 10', 'Alicante', '03001', 'Otra emporesa', 'Recycle', 'EMPRESA');

INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, razon_social, nombre_contacto, rol)
VALUES ('Bela emproesa 3', '12345035X', '600111222', 'bela@empresa3.com', '1234', 'Calle empresa 10', 'Alicante', '03001', 'Una empresa terceera', 'Recycle', 'EMPRESA');

INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, razon_social, nombre_contacto, rol)
VALUES ('Bela emproesa 4', '12355035X', '600111222', 'bela@empresa4.com', '1234', 'Calle empresa 10', 'Alicante', '03001', 'Una empresa cuarta', 'Recycle', 'EMPRESA');


------------------------------------------------------
-- Productos------------------------------------------
------------------------------------------------------
    
    -- Periféricos
INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Ratón Acer OMW', 1, 1, 1, 'Ratón apenas usado con dos botones laterales y boton de cambio de DPI', 'https://placehold.co/600x400/orange/white');

INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Altavoz MiFa', 1, 2, 1, 'Altavoz con uso visible pero completamente funcional', 'https://placehold.co/600x400/green/white');

    
    -- Sobremesa
INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Torre PCGAM Slim', 3, 1, 1, 'Intel I3 16RAM 120 SSD', 'https://thumb.pccomponentes.com/w-530-530/articles/1083/10837879/1830-pcgam-oficina-madrid-slim-intel-core-i3-10100-16gb-500gb-ssd.jpg');

INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Torre dañada Nox', 3, 4, 1, 'Torre rota que se desconoce por que no arranca y antiguo', 'https://placehold.co/400x600/red/black');

    
    -- Componentes
INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Procesador AMD Ryzen 2600', 4, 1, 2, 'Procesador con apenas uso', 'https://placehold.co/600x600/blue/white');

INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Fuente alimentación Tempest Pulse', 4, 2, 1, 'Fuente con varios años de uso pero todavía funcional ni indicios de estropearse', 'https://placehold.co/600x400/red/black');

    
    -- Monitores
INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Monitor Dell Pro 22', 5, 1, 1, 'Monitor Dell de una oficinia que pese al uso esta en buen estado todavía', 'https://placehold.co/600x600/blue/white');

INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Monitor VSDISPLAY LCD', 5, 3, 1, 'Monitor de 4:3 con varias franjas verticales negras aún todavia funcional', 'https://placehold.co/600x400/red/black');

    
    -- Portatiles
INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Portatil HP Pavilion', 2, 1, 1, 'AMD A4 4GB Ram 50Gb hdd', 'https://placehold.co/600x600/blue/white');

INSERT INTO productos(nombre, id_categoria, id_estado, id_disponibilidad, descripcion, imagen_url)
VALUES ('Portatil HP 255 G5', 2, 1, 1, '16Gb Ram 400 Gb Hdd', 'https://placehold.co/600x400/red/black');



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





------------------------------------------------------
-- Solicitudes de productos --------------------------
------------------------------------------------------

-- 1. El usuario 'Particular' (ID 3) solicita un Monitor Dell (ID 7)
-- Estado: 1 (Pendiente)
INSERT INTO solicitudes (id_solicitante, id_producto, motivo, id_estado)
VALUES (4, 7, 'Necesito un monitor para que mi hijo pueda realizar sus tareas escolares en casa, ya que el nuestro se rompió.', 1);

-- 2. El usuario 'Bela' (ID 4) solicita el Portatil HP (ID 9)
-- Estado: 2 (En Revisión)
INSERT INTO solicitudes (id_solicitante, id_producto, motivo, id_estado)
VALUES (4, 9, 'Estoy realizando un curso de formación online y requiero un equipo portátil para poder seguir las clases y entregar los proyectos.', 2);

-- 3. El usuario 'Particular' (ID 3) solicita el Ratón Acer (ID 1)
-- Estado: 3 (Aprobada)
INSERT INTO solicitudes (id_solicitante, id_producto, motivo, id_estado)
VALUES (4, 1, 'Mi ratón actual ha dejado de funcionar y no tengo recursos para adquirir uno nuevo en este momento.', 3);

-- 4. El usuario 'Bela' (ID 4) solicita la Torre PCGAM Slim (ID 3)
-- Estado: 4 (Denegada)
INSERT INTO solicitudes (id_solicitante, id_producto, motivo, id_estado)
VALUES (4, 3, 'Solicito este equipo para montar un servidor doméstico de pruebas.', 4);

-- 5. El usuario 'Particular' (ID 3) solicita el Altavoz MiFa (ID 2)
-- Estado: 5 (Entregada)
INSERT INTO solicitudes (id_solicitante, id_producto, motivo, id_estado)
VALUES (4, 2, 'Necesito un dispositivo de audio para mis clases de idiomas online.', 5);

------------------------------------------------------
-- Más Solicitudes para el Usuario ID 4 (Bela) -------
------------------------------------------------------

-- 1. Solicita el Monitor VSDISPLAY (ID 8)
-- Estado: 1 (Pendiente)
INSERT INTO solicitudes (id_solicitante, id_producto, motivo, id_estado)
VALUES (4, 8, 'Necesito un segundo monitor para mejorar mi productividad mientras estudio programación.', 1);

-- 2. Solicita el Procesador AMD Ryzen (ID 5)
-- Estado: 2 (En Revisión)
INSERT INTO solicitudes (id_solicitante, id_producto, motivo, id_estado)
VALUES (4, 5, 'Mi procesador actual falla constantemente y necesito este componente para reparar mi equipo principal.', 2);

-- 3. Solicita el Portatil HP 255 G5 (ID 10)
-- Estado: 3 (Aprobada)
INSERT INTO solicitudes (id_solicitante, id_producto, motivo, id_estado)
VALUES (4, 10, 'Requiero un equipo con más memoria RAM para poder ejecutar máquinas virtuales de mis prácticas.', 3);

-- 4. Solicita la Fuente de alimentación Tempest (ID 6)
-- Estado: 5 (Entregada)
INSERT INTO solicitudes (id_solicitante, id_producto, motivo, id_estado)
VALUES (4, 6, 'La fuente de mi ordenador se quemó tras una subida de tensión y necesito esta de sustitución.', 5);

-- 5. Solicita la Torre dañada Nox (ID 4)
-- Estado: 4 (Denegada)
INSERT INTO solicitudes (id_solicitante, id_producto, motivo, id_estado)
VALUES (4, 4, 'Me gustaría obtener esta torre para practicar soldadura y reparación de placas base.', 4);