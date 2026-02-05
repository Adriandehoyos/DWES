import Equipo from "../models/Equipos";
import Heroe from "../models/Heroes";
import { Request, Response } from 'express';

//get all
export const allHeroes = async (req: Request, res: Response) => {
  const heroes = await Heroe.findAll({
    include: [{model: Equipo}]
  });
  res.json(heroes);
};

//get por id
export const heroeId = async (req: Request, res: Response) => {
    const { id } = req.params;

    const heroe = await Heroe.findByPk(Number(id), {
    include: [{model: Equipo}]
  });
  res.json(heroe);
};

//post
export const crearHeroe = async (req: Request, res: Response) => {
  const body = req.body;
  const nuevoHeroe = await Heroe.create(body);
  res.status(201).json(nuevoHeroe);
};

//put
export const actualizarHeroe = async (req: Request, res: Response) => {
  const { id } = req.params;       
  const body = req.body;              
  
  try {
    // Primero buscamos el equipo por su ID
    const heroe = await Heroe.findByPk(Number(id));
    
    // Si no existe, respondemos con error 404 (Not Found)
    if (!heroe) {
    return res.status(404).json({
        msg: 'heroe no encontrado'
    });
    }
    
    await heroe.update(body);
    
    // Respondemos con el equipo actualizado
    res.json(heroe);
    } catch (error) {
        res.status(500).json({
        msg: 'Error al actualizar el heroe o equipo',
        error
        });
}
};

//delete
export const eliminarHeroe = async (req: Request, res: Response) => {
  const { id } = req.params;
  
  try {
    const heroe = await Heroe.findByPk(Number(id));
    
    if (!heroe) {
      return res.status(404).json({
        msg: 'Heroe no encontrado'
      });
    }
    
    await heroe.destroy();
    res.json({
      msg: 'Heroe eliminado correctamente'
    });
  } catch (error) {
    res.status(500).json({
      msg: 'Error al eliminar el heroe',
      error
    });
  }
};

//filtra heroes por equipo
export const heroesPorEquipo = async (req: Request, res: Response) => {
  const { equipo_id } = req.params;

  try {
    const heroes = await Heroe.findAll({
      where: { equipo_id }
    });

    res.json(heroes);
  } catch (error) {
    res.status(500).json({ msg: 'Error al obtener heroes del equipo', error });
  }
};