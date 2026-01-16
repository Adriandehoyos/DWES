import { Request, Response } from 'express';
import Pista from '../models/pista';

//Post
export const crearPista = async (req: Request, res: Response) => {
    const {nombre, tipo, precio_hora} = req.body;
    const nuevaPista = await Pista.create({nombre, tipo, precio_hora});
    res.status(201).json(nuevaPista);
}


//Get all
export const allPistas = async (req: Request, res: Response) => {
    const pistas = await Pista.findAll();
    res.json(pistas);
};


//Get por id
export const pistaPorId = async (req: Request, res: Response) => {
    const {id} = req.params;
    const pista = await Pista.findByPk(id);
    res.json(pista);
}



//Put
export const actualizarPista = async (req: Request, res: Response) => {
    const {id} = req.params;
    const body = req.body;

    try {
        const pista = await Pista.findByPk(id);

        if (!pista) {
            return res.status(404).json({
                msg: 'Pista no encontrada'
            });
        }

        await pista.update(body);

        res.json(pista);
    } catch (error) {
        res.status(500).json({
            msg: 'Error al actualizar la pista',
            error
        });
    }
}



//Delete
export const eliminarPista = async (req: Request, res: Response) => {
    const {id} = req.params;

    try{
        const pista = await Pista.findByPk(id);

        if (!pista) {
            return res.status(404).json({
            msg: 'Pista no encontrada'
        });
        }
        await pista.destroy();
        res.json({
            msg: 'Pista eliminada correctamente'
        });
        
    }catch(error){
        res.status(500).json({
            msg: 'Error al actualizar la pista',
            error
        });
    }


}