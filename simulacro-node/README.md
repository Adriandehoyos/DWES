Método: POST
URL: http://localhost:3000/api/libros
Body (raw JSON):
{
  "titulo": "Harry Potter y la Piedra Filosofal",
  "autor": "J.K. Rowling",
  "isbn": "978-8478884452"
}

### ** 4. Actualizar Libro (PUT)**
```
Método: PUT
URL: http://localhost:3000/api/libros/1
Body (raw JSON):
{
  "titulo": "1984 - Edición Especial",
  "autor": "George Orwell",
  "isbn": "978-0451524935"
}

### ** 1. Crear Préstamo Válido (POST)**
```
Método: POST
URL: http://localhost:3000/api/prestamos
Body (raw JSON):

{
  "libro_id": 3,
  "usuario_id": 1,
  "fecha_prestamo": "2026-01-28",
  "fecha_devolucion": null
}

### get de prestamos por usuario
http://localhost:3000/api/prestamos/usuario/1