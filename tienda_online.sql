
CREATE DATABASE IF NOT EXISTS tienda_online
 CHARACTER SET utf8mb4
 COLLATE utf8mb4_unicode_ci;
USE tienda_online;
CREATE TABLE IF NOT EXISTS pedidos (
 id BIGINT AUTO_INCREMENT PRIMARY KEY,
 nombre_cliente VARCHAR(100) NOT NULL,
 fecha_pedido DATETIME NOT NULL,
 importe_total DECIMAL(10,2) NOT NULL,
 estado VARCHAR(20) NOT NULL
 -- Por ejemplo: 'PENDIENTE', 'ENVIADO', 'CANCELADO'
);