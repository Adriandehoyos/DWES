// Importamos tipos de Express para tipar las funciones
import { Request, Response } from 'express';
// Importamos el modelo Libro para hacer operaciones CRUD
import Libro from '../models/Libro';

/**
 * POST /api/libros
 * Crea un nuevo libro en la base de datos
 */
export const crearLibro = async (req: Request, res: Response) => {
  // Extraemos los datos del cuerpo de la petición (JSON enviado por Postman)
  const { titulo, autor, isbn } = req.body;
  
  // Usamos el método create() de Sequelize para insertar en la BD
  // Equivale a: INSERT INTO libros (titulo, autor, isbn) VALUES (...)
  const nuevoLibro = await Libro.create({ titulo, autor, isbn });
  
  // Respondemos con código 201 (Created) y el objeto creado en formato JSON
  res.status(201).json(nuevoLibro);
};

/**
 * GET /api/libros
 * Obtiene todos los libros de la base de datos
 */
export const allLibros = async (req: Request, res: Response) => {
  // findAll() obtiene todos los registros
  // Equivale a: SELECT * FROM libros
  const libros = await Libro.findAll();
  
  // Respondemos con código 200 (OK) implícito y el array de libros
  res.json(libros);
};

/**
 * GET /api/libros/:id
 * Obtiene un libro específico por su ID
 */
export const libroPorId = async (req: Request, res: Response) => {
  // Extraemos el parámetro 'id' de la URL
  // Ejemplo: /api/libros/1 → id = "1"
  const {id} = req.params;
  
  // findByPk() busca por Primary Key (id)
  // Equivale a: SELECT * FROM libros WHERE id = ?
  const libro = await Libro.findByPk(Number(id));
  
  res.json(libro);
};

/**
 * PUT /api/libros/:id
 * Actualiza un libro existente
 */
export const actualizarLibro = async (req: Request, res: Response) => {
  const { id } = req.params;           // ID del libro a actualizar
  const body = req.body;               // Nuevos datos del libro
  
  try {
    // Primero buscamos el libro por su ID
    const libro = await Libro.findByPk(Number(id));
    
    // Si no existe, respondemos con error 404 (Not Found)
    if (!libro) {
      return res.status(404).json({
        msg: 'Libro no encontrado'
      });
    }
    
    // Si existe, lo actualizamos con los nuevos datos
    // Equivale a: UPDATE libros SET ... WHERE id = ?
    await libro.update(body);
    
    // Respondemos con el libro actualizado
    res.json(libro);
  } catch (error) {
    // Si hay algún error (ej: ISBN duplicado), lo capturamos
    res.status(500).json({
      msg: 'Error al actualizar el libro',
      error
    });
  }
};

/**
 * DELETE /api/libros/:id
 * Elimina un libro de la base de datos
 */
export const eliminarLibro = async (req: Request, res: Response) => {
  const { id } = req.params;
  
  try {
    // Buscamos el libro
    const libro = await Libro.findByPk(Number(id));
    
    // Si no existe, error 404
    if (!libro) {
      return res.status(404).json({
        msg: 'Libro no encontrado'
      });
    }
    
    // Si existe, lo eliminamos
    // Equivale a: DELETE FROM libros WHERE id = ?
    await libro.destroy();
    
    res.json({
      msg: 'Libro eliminado correctamente'
    });
  } catch (error) {
    // Si hay error (ej: tiene préstamos asociados), lo capturamos
    res.status(500).json({
      msg: 'Error al eliminar el libro',
      error
    });
  }
};