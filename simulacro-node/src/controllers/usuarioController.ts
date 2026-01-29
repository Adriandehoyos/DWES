import { Request, Response } from 'express';
import Usuario from '../models/Usuario';

/**
 * POST /api/usuarios
 * Crea un nuevo usuario
 */
export const crearUsuario = async (req: Request, res: Response) => {
  const { nombre, email } = req.body;
  const nuevoUsuario = await Usuario.create({ nombre, email });
  res.status(201).json(nuevoUsuario);
};

/**
 * GET /api/usuarios
 * Obtiene todos los usuarios
 */
export const allUsuarios = async (req: Request, res: Response) => {
  const usuarios = await Usuario.findAll();
  res.json(usuarios);
};

/**
 * GET /api/usuarios/:id
 * Obtiene un usuario por ID
 */
export const usuarioPorId = async (req: Request, res: Response) => {
  const { id } = req.params;
  const usuario = await Usuario.findByPk(Number(id));
  res.json(usuario);
};

/**
 * PUT /api/usuarios/:id
 * Actualiza un usuario existente
 */
export const actualizarUsuario = async (req: Request, res: Response) => {
  const { id } = req.params;
  const body = req.body;
  
  try {
    const usuario = await Usuario.findByPk(Number(id));
    
    if (!usuario) {
      return res.status(404).json({
        msg: 'Usuario no encontrado'
      });
    }
    
    await usuario.update(body);
    res.json(usuario);
  } catch (error) {
    res.status(500).json({
      msg: 'Error al actualizar el usuario',
      error
    });
  }
};

/**
 * DELETE /api/usuarios/:id
 * Elimina un usuario
 */
export const eliminarUsuario = async (req: Request, res: Response) => {
  const { id } = req.params;
  
  try {
    const usuario = await Usuario.findByPk(Number(id));
    
    if (!usuario) {
      return res.status(404).json({
        msg: 'Usuario no encontrado'
      });
    }
    
    await usuario.destroy();
    res.json({
      msg: 'Usuario eliminado correctamente'
    });
  } catch (error) {
    res.status(500).json({
      msg: 'Error al eliminar el usuario',
      error
    });
  }
};