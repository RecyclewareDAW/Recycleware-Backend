-- SCRIPT COMPLETO RECYCLEWARE
-- Generado para integración con Spring Boot Backend

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- 1. CREACIÓN DEL ESQUEMA
DROP SCHEMA IF EXISTS `recycleware`;
CREATE SCHEMA IF NOT EXISTS `recycleware` DEFAULT CHARACTER SET utf8;
USE `recycleware`;

-- 2. TABLA USUARIOS (Optimizado para Encriptación y Multiusuario)
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `dni` VARCHAR(9) NOT NULL UNIQUE,
  `telefono` VARCHAR(15) NOT NULL,
  `correo` VARCHAR(100) NOT NULL UNIQUE,
  `contraseña` VARCHAR(255) NOT NULL, -- Longitud para BCrypt
  `direccion` VARCHAR(200) NOT NULL,
  `provincia` VARCHAR(100) NOT NULL,
  `codigo_postal` VARCHAR(10) NOT NULL,
  `razon_social` VARCHAR(100) NULL DEFAULT NULL,
  `nombre_contacto` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

-- 3. TABLAS MAESTRAS (Estados y Categorías)
CREATE TABLE IF NOT EXISTS `categorias_producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `estados_producto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `estados_solicitud` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

-- 4. TABLA PRODUCTOS (Con URL de Imagen para mayor rendimiento)
CREATE TABLE IF NOT EXISTS `productos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `id_categoria` INT NOT NULL,
  `id_estado` INT NOT NULL,
  `descripcion` TEXT NOT NULL,
  `imagen_url` VARCHAR(500) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_prod_cat` FOREIGN KEY (`id_categoria`) REFERENCES `categorias_producto` (`id`),
  CONSTRAINT `fk_prod_est` FOREIGN KEY (`id_estado`) REFERENCES `estados_producto` (`id`)
) ENGINE = InnoDB;

-- 5. TABLA DONACIONES (Registro de entradas de material)
CREATE TABLE IF NOT EXISTS `donaciones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_donante` INT NOT NULL,
  `fecha_donacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cantidad_productos` INT NOT NULL DEFAULT 1,
  `descripcion` TEXT NOT NULL,
  `peso` FLOAT NULL,
  `volumen` FLOAT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_don_usr` FOREIGN KEY (`id_donante`) REFERENCES `usuarios` (`id`)
) ENGINE = InnoDB;

-- 6. TABLA SOLICITUDES (Gestión de entregas a usuarios/entidades)
CREATE TABLE IF NOT EXISTS `solicitudes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_solicitante` INT NOT NULL,
  `id_producto` INT NOT NULL,
  `motivo` TEXT NOT NULL,
  `id_estado` INT NOT NULL DEFAULT 1, -- Por defecto 'Pendiente'
  `fecha_solicitud` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_sol_usr` FOREIGN KEY (`id_solicitante`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `fk_sol_prd` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id`),
  CONSTRAINT `fk_sol_est` FOREIGN KEY (`id_estado`) REFERENCES `estados_solicitud` (`id`)
) ENGINE = InnoDB;

-- 7. TABLA MENSAJES DE CONTACTO
CREATE TABLE IF NOT EXISTS `mensajes_contacto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `correo` VARCHAR(100) NOT NULL,
  `asunto` VARCHAR(100) NOT NULL,
  `mensaje` TEXT NOT NULL,
  `id_usuario` INT NULL DEFAULT NULL,
  `fecha_envio` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_msg_usr` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- INSERCIÓN DE DATOS INICIALES (PARA PRUEBAS)
-- -----------------------------------------------------

INSERT INTO `categorias_producto` (nombre) VALUES 
('Periféricos'), ('Portátiles'), ('Sobremesa'), ('Componentes'), ('Monitores');

INSERT INTO `estados_producto` (nombre) VALUES 
('Excelente'), ('Funcional'), ('Dañado'), ('Para Piezas');

INSERT INTO `estados_solicitud` (nombre) VALUES 
('Pendiente'), ('Revisión'), ('Aprobada'), ('Denegada'), ('Entregada');

-- Usuario de prueba (Contraseña: 'admin123' - pero recuerda encriptarla en Java)
INSERT INTO `usuarios` (`nombre`, `dni`, `telefono`, `correo`, `contraseña`, `direccion`, `provincia`, `codigo_postal`)
VALUES ('Admin Recycle', '12345678X', '600111222', 'admin@recycleware.com', 'admin123', 'Calle Principal 1', 'Madrid', '28001');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;