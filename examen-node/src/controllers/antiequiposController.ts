import { Request, Response } from 'express';
import Antiequipo from '../models/Antiequipos';

//Get de todos los antiequipos
export const allAntiequipos = async (req: Request, res: Response) => {
  const antiequipos = await Antiequipo.findAll();
  res.json(antiequipos);
};

//get por id
export const antiEquipoId = async (req: Request, res: Response) => {
    const {id} = req.params;
    const aequipo = await Antiequipo.findByPk(Number(id));
    res.json(aequipo);
};

//post
export const crearAEquipo = async (req: Request, res: Response) => {
    const body = req.body;
    const nAEquipo = await Antiequipo.create(body);
    res.status(201).json(nAEquipo);
};

//put
export const actualizarAEquipo = async (req: Request, res: Response) => {
  const { id } = req.params;       
  const body = req.body;              
  
  try {
    // Primero buscamos el Antiequipo por su ID
    const aequipo = await Antiequipo.findByPk(Number(id));
    
    // Si no existe, respondemos con error 404 (Not Found)
    if (!aequipo) {
    return res.status(404).json({
        msg: 'Antiequipo no encontrado'
    });
    }
    
    await aequipo.update(body);
    
    // Respondemos con el Antiequipo actualizado
    res.json(aequipo);
    } catch (error) {
        res.status(500).json({
        msg: 'Error al actualizar el Antiequipo',
        error
        });
}
};


//Delete
export const eliminarAEquipo = async (req: Request, res: Response) => {
  const { id } = req.params;                    
  
  try {
    // Primero buscamos el Antiequipo por su ID
    const aequipo = await Antiequipo.findByPk(Number(id));
    
    // Si no existe, respondemos con error 404 (Not Found)
    if (!aequipo) {
    return res.status(404).json({
        msg: 'Antiequipo no encontrado'
    });
    }
    
    await aequipo.destroy();
    
    res.json({
      msg: 'Antiequipo eliminado correctamente'
    });
    } catch (error) {
        res.status(500).json({
        msg: 'Error al eliminar el antiequipo',
        error
        });
}
};