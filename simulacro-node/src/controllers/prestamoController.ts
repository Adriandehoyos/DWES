import { Request, Response } from 'express';
import Prestamo from '../models/Prestamo';
import Libro from '../models/Libro';
import Usuario from '../models/Usuario';
/**
 * POST /api/prestamos
 * Crea un nuevo préstamo
 * Requiere: libro_id, usuario_id, fecha_prestamo, fecha_devolucion (opcional)
 */
export const crearPrestamo = async (req: Request, res: Response) => {
  // El body debe contener: libro_id, usuario_id, fecha_prestamo, fecha_devolucion
  const body = req.body;
  const nuevoPrestamo = await Prestamo.create(body);
  res.status(201).json(nuevoPrestamo);
};

/**
 * GET /api/prestamos
 * Obtiene todos los préstamos
 */
export const allPrestamos = async (req: Request, res: Response) => {
  const prestamos = await Prestamo.findAll();
  res.json(prestamos);
};

/**
 * DELETE /api/prestamos/:id
 * Elimina/cancela un préstamo
 */
export const eliminarPrestamo = async (req: Request, res: Response) => {
  const { id } = req.params;
  
  try {
    const prestamo = await Prestamo.findByPk(Number(id));
    
    if (!prestamo) {
      return res.status(404).json({
        msg: 'Préstamo no encontrado'
      });
    }
    
    await prestamo.destroy();
    res.json({
      msg: 'Préstamo eliminado correctamente'
    });
  } catch (error) {
    res.status(500).json({
      msg: 'Error al eliminar el préstamo',
      error
    });
  }
};

// Nuevo método: buscar préstamos por usuario
export const prestamosPorUsuario = async (req: Request, res: Response) => {
  const { usuario_id } = req.params;

  try {
    const prestamos = await Prestamo.findAll({
      where: { usuario_id },
      include: [{ model: Libro }] // Trae info de cada libro
    });

    res.json(prestamos);
  } catch (error) {
    res.status(500).json({ msg: 'Error al obtener préstamos del usuario', error });
  }
};

/**
 * GET /api/prestamos/:id
 * Busca un préstamo por su ID y devuelve información del libro y usuario
 */
export const prestamoPorId = async (req: Request, res: Response) => {
  const { id } = req.params;

  try {
    // findByPk busca por primary key (id)
    // include trae los datos relacionados (Libro y Usuario)
    const prestamo = await Prestamo.findByPk(Number(id), {
      include: [Libro, Usuario]
    });

    if (!prestamo) {
      return res.status(404).json({ msg: 'Préstamo no encontrado' });
    }

    res.json(prestamo);
  } catch (error) {
    res.status(500).json({ msg: 'Error al buscar el préstamo', error });
  }
};