import Reserva from "../models/reserva";
import { Request, Response } from 'express';

//Post
export const crearReserva = async (req: Request, res: Response) => {
    const body = req.body;
    const nuevaReserva = await Reserva.create(body);
    res.status(201).json(nuevaReserva);
}


//Get
export const allReservas = async (req: Request, res: Response) => {
    const reservas = await Reserva.findAll();
    res.json(reservas);
};


//Delete
export const eliminarReserva = async (req: Request, res: Response) => {
    const {id} = req.params;

    try{
        const reserva = await Reserva.findByPk(id);

        if (!reserva) {
            return res.status(404).json({
            msg: 'Reserva no encontrada'
        });
        }
        await reserva.destroy();
        res.json({
            msg: 'Reserva eliminada correctamente'
        });
        
    }catch(error){
        res.status(500).json({
            msg: 'Error al actualizar la pista',
            error
        });
    }
}