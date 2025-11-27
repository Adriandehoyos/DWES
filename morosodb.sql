CREATE DATABASE IF NOT EXISTS morososdb;
USE morososdb;
CREATE TABLE moroso (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
dni VARCHAR(12) NOT NULL UNIQUE,
cantidad_adeudada DECIMAL(10,2) NOT NULL,
fecha_alta DATE NOT NULL,
estado_pago ENUM('PENDIENTE', 'PAGADO') DEFAULT 'PENDIENTE'
);

INSERT INTO moroso (nombre, dni, cantidad_adeudada, fecha_alta, estado_pago)
VALUES
('Carlos Méndez Ruiz', '12345678A', 450.75, '2025-01-12', 'PENDIENTE'),
('Laura Gómez Herrera', '98765432B', 1200.00, '2025-02-05', 'PAGADO');

select * from moroso;