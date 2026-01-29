// Router es una clase de Express que nos permite definir rutas
import { Router } from "express";
// Importamos todas las funciones del controlador
import { 
  actualizarLibro, 
  allLibros, 
  crearLibro, 
  eliminarLibro, 
  libroPorId 
} from "../controllers/libroController";

// Creamos una instancia de Router
const router = Router();

/**
 * Definimos las rutas y las conectamos con las funciones del controlador
 * 
 * Formato: router.METODO(RUTA, FUNCIÓN)
 */

// GET /api/libros → Listar todos los libros
router.get('/libros', allLibros);

// POST /api/libros → Crear un nuevo libro
router.post('/libros', crearLibro);

// GET /api/libros/:id → Obtener un libro específico
// :id es un parámetro dinámico (ej: /api/libros/1)
router.get('/libros/:id', libroPorId);

// PUT /api/libros/:id → Actualizar un libro
router.put('/libros/:id', actualizarLibro);

// DELETE /api/libros/:id → Eliminar un libro
router.delete('/libros/:id', eliminarLibro);

// Exportamos el router para usarlo en index.ts
export default router;