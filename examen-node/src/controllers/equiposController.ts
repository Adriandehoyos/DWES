import Equipo from "../models/Equipos";
import { Request, Response } from 'express';
import Heroe from "../models/Heroes";

//Get de todos los equipos
export const allEquipos = async (req: Request, res: Response) => {
  const equipos = await Equipo.findAll();
  res.json(equipos);
};

//get por id
export const equipoId = async (req: Request, res: Response) => {
    const {id} = req.params;
    const equipo = await Equipo.findByPk(Number(id));
    res.json(equipo);
};

//post
export const crearEquipo = async (req: Request, res: Response) => {
    const body = req.body;
    const nEquipo = await Equipo.create(body);
    res.status(201).json(nEquipo);
};

//Put
export const actualizarEquipo = async (req: Request, res: Response) => {
  const { id } = req.params;       
  const body = req.body;              
  
  try {
    // Primero buscamos el equipo por su ID
    const equipo = await Equipo.findByPk(Number(id));
    
    // Si no existe, respondemos con error 404 (Not Found)
    if (!equipo) {
    return res.status(404).json({
        msg: 'Equipo no encontrado'
    });
    }
    
    await equipo.update(body);
    
    // Respondemos con el equipo actualizado
    res.json(equipo);
    } catch (error) {
        res.status(500).json({
        msg: 'Error al actualizar el equipo',
        error
        });
}
};


//Delete
export const eliminarEquipo = async (req: Request, res: Response) => {
  const { id } = req.params;                    
  
  try {
    // Primero buscamos el equipo por su ID
    const equipo = await Equipo.findByPk(Number(id));
    
    // Si no existe, respondemos con error 404 (Not Found)
    if (!equipo) {
    return res.status(404).json({
        msg: 'Equipo no encontrado'
    });
    }
    
    await equipo.destroy();
    
    res.json({
      msg: 'Equipo eliminado correctamente'
    });
    } catch (error) {
        res.status(500).json({
        msg: 'Error al eliminar el equipo',
        error
        });
}
};

//get de los heroes de un equipo por id
export const heroesPorEquipoId = async (req: Request, res: Response) => {
  const { id } = req.params;

  try {
    // findByPk busca por primary key (id)
    // include trae los datos relacionados (Heroes)
    const equipo = await Equipo.findByPk(Number(id), {
      include: [{model: Heroe}]
    });

    if (!equipo) {
      return res.status(404).json({ msg: 'Equipo no encontrado' });
    }

    res.json(equipo);
  } catch (error) {
    res.status(500).json({ msg: 'Error al buscar el equipo', error });
  }
};