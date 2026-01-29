-- ==============================
-- BASE DE DATOS: Biblioteca
-- ==============================

DROP DATABASE IF EXISTS biblioteca_db;
CREATE DATABASE biblioteca_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE biblioteca_db;

-- ==============================
-- TABLA: libros
-- ==============================
CREATE TABLE libros (
  id INT AUTO_INCREMENT PRIMARY KEY,
  titulo VARCHAR(100) NOT NULL,
  autor VARCHAR(100) NOT NULL,
  isbn VARCHAR(20) NOT NULL,
  
  UNIQUE KEY uq_libros_isbn (isbn)
);

-- ==============================
-- TABLA: usuarios
-- ==============================
CREATE TABLE usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  
  UNIQUE KEY uq_usuarios_email (email)
);

-- ==============================
-- TABLA: prestamos
-- ==============================
CREATE TABLE prestamos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  libro_id INT NOT NULL,
  usuario_id INT NOT NULL,
  fecha_prestamo DATE NOT NULL,
  fecha_devolucion DATE,
  
  CONSTRAINT fk_prestamos_libros
    FOREIGN KEY (libro_id) REFERENCES libros(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
    
  CONSTRAINT fk_prestamos_usuarios
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
    
  -- Evita que un usuario pida el mismo libro múltiples veces simultáneamente
  UNIQUE KEY uq_prestamo_activo (libro_id, usuario_id, fecha_prestamo)
);

-- ==============================
-- DATOS DE EJEMPLO
-- ==============================

-- Insertar libros
INSERT INTO libros (titulo, autor, isbn) VALUES
  ('1984', 'George Orwell', '978-0451524935'),
  ('Cien años de soledad', 'Gabriel García Márquez', '978-0307474728'),
  ('El Quijote', 'Miguel de Cervantes', '978-8420412146');

-- Insertar usuarios
INSERT INTO usuarios (nombre, email) VALUES
  ('Juan Pérez', 'juan@email.com'),
  ('María García', 'maria@email.com'),
  ('Carlos López', 'carlos@email.com');

-- Insertar préstamos de ejemplo
INSERT INTO prestamos (libro_id, usuario_id, fecha_prestamo, fecha_devolucion) VALUES
  (1, 1, '2026-01-20', NULL),  -- Juan tiene prestado "1984" (aún no devuelto)
  (2, 2, '2026-01-15', '2026-01-25');  -- María devolvió "Cien años de soledad"