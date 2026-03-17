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


------------------------------------------------------
-- Usuarios y Comentarios para mostrar en la parte de comunidad (Ricardo) -------
------------------------------------------------------

-- USUARIOS FICTICIOS (6 PARTICULARES / BENEFICIARIOS)

INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, rol) VALUES
    ('Carlos Martínez', '11111111A', '600111222', 'carlos@mail.com', '12345678', 'Calle Mayor 12, 3B', 'Alicante', '03002', 'PARTICULAR'),
    ('Laura Gómez', '22222222B', '600222333', 'laura@mail.com', '12345678', 'Avenida Libertad 45', 'San Vicente del Raspeig', '03690', 'PARTICULAR'),
    ('Ahmed Ruiz', '33333333C', '600333444', 'ahmed@mail.com', '12345678', 'Plaza de los Luceros 1', 'Alicante', '03001', 'PARTICULAR'),
    ('Sofía Navarro', '44444444D', '600444555', 'sofia@mail.com', '12345678', 'Calle del Sol 8', 'Mutxamel', '03110', 'PARTICULAR'),
    ('David López', '55555555E', '600555666', 'david@mail.com', '12345678', 'Avenida Costa Blanca 120', 'San Juan Playa', '03540', 'PARTICULAR'),
    ('Elena Torres', '66666666F', '600666777', 'elena@mail.com', '12345678', 'Calle San Fernando 33', 'Alicante', '03005', 'PARTICULAR');

-- USUARIOS FICTICIOS (6 EMPRESAS / DONANTES)

INSERT INTO usuarios (nombre, dni, telefono, correo, contrasenia, direccion, localidad, codigo_postal, razon_social, nombre_contacto, rol) VALUES
    ('TechCorp Solutions', 'B11111111', '965111222', 'info@techcorp.com', '12345678', 'Parque Tecnológico, Nave 4', 'Alicante', '03008', 'TechCorp Iberia S.L.', 'Marcos Soler', 'EMPRESA'),
    ('InnovaTech Alicante', 'B22222222', '965222333', 'donaciones@innovatech.es', '12345678', 'Polígono Canastell, C/ Industria', 'San Vicente del Raspeig', '03690', 'Innovación Tecnológica S.A.', 'Sara Méndez', 'EMPRESA'),
    ('Global Logistics', 'B33333333', '965333444', 'sostenibilidad@global.com', '12345678', 'Avenida de Elche 150', 'Alicante', '03008', 'Global Logistics España', 'Javier Ramos', 'EMPRESA'),
    ('EcoSoft Dev', 'B44444444', '965444555', 'rrhh@ecosoft.com', '12345678', 'Calle Innovación 2', 'Mutxamel', '03110', 'EcoSoft Development S.L.', 'Ana Pastor', 'EMPRESA'),
    ('Agencia Creativa', 'B55555555', '965555666', 'hola@agenciacreativa.es', '12345678', 'Calle San Rafael 4', 'San Juan Pueblo', '03550', 'Estudio Creativo S.A.', 'Pedro Giménez', 'EMPRESA'),
    ('Consultoría IT', 'B66666666', '965666777', 'admin@consultoriait.es', '12345678', 'Avenida Maisonnave 28, Entresuelo', 'Alicante', '03003', 'Consultores Informáticos S.L.', 'Lucía Vidal', 'EMPRESA');

-- RESEÑAS DE LA COMUNIDAD (12 RESEÑAS)

INSERT INTO resenas (texto, autor, rol, estrellas, activa) VALUES
    ('Renovamos la oficina y donar los equipos antiguos fue un proceso rápido y transparente. Nos enorgullece saber que tendrán una segunda vida útil.', 'TechCorp Solutions', 'EMPRESA', 5, TRUE),
    ('Gracias a RecycleWare conseguí un portátil para que mi hijo pudiera hacer los deberes del instituto. Ha sido una gran ayuda para nuestra familia.', 'Carlos M.', 'PARTICULAR', 5, TRUE),
    ('Excelente plataforma. Nos emitieron el certificado de donación sin problemas y vinieron a recoger los monitores puntualmente.', 'InnovaTech Alicante', 'EMPRESA', 5, TRUE),
    ('Llevaba meses ahorrando para un ordenador de sobremesa para estudiar programación. El equipo funciona de maravilla, ¡muchísimas gracias!', 'Laura G.', 'PARTICULAR', 5, TRUE),
    ('Teníamos 5 ordenadores cogiendo polvo en el almacén. Saber que ahora los están usando familias que lo necesitan es una satisfacción enorme.', 'Agencia Creativa', 'EMPRESA', 5, TRUE),
    ('El monitor que recibí está en perfecto estado. Me ha facilitado mucho el teletrabajo. Una iniciativa increíble.', 'Ahmed R.', 'PARTICULAR', 4, TRUE),
    ('Me donaron componentes para arreglar mi viejo ordenador y ahora vuela. El proceso de solicitud fue súper rápido y transparente.', 'Sofía N.', 'PARTICULAR', 5, TRUE),
    ('Como empresa de logística, la sostenibilidad es clave. RecycleWare nos ayudó a deshacernos de nuestra basura electrónica de forma responsable.', 'Global Logistics', 'EMPRESA', 4, TRUE),
    ('Poder acceder a esta tecnología me ha abierto puertas para seguir formándome online. Eternamente agradecido al equipo y a los donantes.', 'David L.', 'PARTICULAR', 5, TRUE),
    ('Súper sencillo. Subimos el lote de portátiles a la plataforma y en menos de una semana ya estaban asignados a estudiantes locales.', 'EcoSoft Dev', 'EMPRESA', 5, TRUE),
    ('El trato de los voluntarios fue excepcional. Me explicaron cómo instalar todo y el ordenador va perfecto. 100% recomendable.', 'Elena T.', 'PARTICULAR', 4, TRUE),
    ('Nos guiaron en el proceso de borrado seguro de datos antes de entregar los discos duros. Muy profesionales y una gran labor social.', 'Consultoría IT', 'EMPRESA', 5, TRUE);