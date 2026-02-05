import { Request, Response } from 'express';
import Villano from '../models/Villanos';
import Antiequipo from '../models/Antiequipos';

//get all
export const allVillanos = async (req: Request, res: Response) => {
  const villanos = await Villano.findAll({
    include: [{model: Antiequipo}]
  });
  res.json(villanos);
};

//get por id
export const villanoId = async (req: Request, res: Response) => {
    const { id } = req.params;

    const villano = await Villano.findByPk(Number(id), {
    include: [{model: Antiequipo}]
  });
  res.json(villano);
};

//post
export const crearVillano = async (req: Request, res: Response) => {
  const body = req.body;
  const nuevoV = await Villano.create(body);
  res.status(201).json(nuevoV);
};

//put
export const actualizarVillano = async (req: Request, res: Response) => {
  const { id } = req.params;       
  const body = req.body;              
  
  try {
    // Primero buscamos el equipo por su ID
    const villano = await Villano.findByPk(Number(id));
    
    // Si no existe, respondemos con error 404 (Not Found)
    if (!villano) {
    return res.status(404).json({
        msg: 'villano no encontrado'
    });
    }
    
    await villano.update(body);
    
    // Respondemos con el equipo actualizado
    res.json(villano);
    } catch (error) {
        res.status(500).json({
        msg: 'Error al actualizar el villano o equipo',
        error
        });
}
};

//delete
export const eliminarVillano = async (req: Request, res: Response) => {
  const { id } = req.params;
  
  try {
    const villano = await Villano.findByPk(Number(id));
    
    if (!villano) {
      return res.status(404).json({
        msg: 'villano no encontrado'
      });
    }
    
    await villano.destroy();
    res.json({
      msg: 'villano eliminado correctamente'
    });
  } catch (error) {
    res.status(500).json({
      msg: 'Error al eliminar el villano',
      error
    });
  }
};

//filtra heroes por equipo
export const villanosPorAntiequipos = async (req: Request, res: Response) => {
  const { antiequipo_id } = req.params;

  try {
    const villanos = await Villano.findAll({
      where: { antiequipo_id }
    });

    res.json(villanos);
  } catch (error) {
    res.status(500).json({ msg: 'Error al obtener villanos del Antiequipo', error });
  }
};