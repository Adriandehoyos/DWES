import { Request, Response } from 'express';
import { pistas } from '../data';
import { Pista } from '../model/pista';


export const listarPistas = (req: Request, res: Response) => {
// Explicación: Devolver las pistas disponibles en formato JSON
res.status(200).json(pistas);
}
//post
export const agregarPista = (req: Request, res: Response) => {
    const {nombre, reservada } = req.body;
    const newpista: Pista = { id: pistas.length + 1, nombre, reservada };
    pistas.push(newpista);
    res.status(201).json(newpista);
}

//put
export const reservarPista = (req: Request, res: Response) => {
    const pistaId = parseInt(req.params.id);
    const {nombre, reservada} = req.body;

    const pista = pistas.find(p=> p.id === pistaId);

    if(!pista){
        return res.status(404).json({ message: 'Pista no encontrada' });
    }else{
        pista.nombre = nombre || pista.nombre;
        pista.reservada = reservada || pista.reservada;
        res.json(pista);
    }
}

//put
export const cancelarReserva = (req: Request, res: Response) => {
    const pistaId = parseInt(req.params.id);
    const {nombre, reservada} = req.body;

    const pista = pistas.find(p=> p.id === pistaId);

    if(!pista){
        return res.status(404).json({ message: 'Pista no encontrada' });
    }else{
        pista.nombre = nombre || pista.nombre;
        pista.reservada;
        res.json(pista);
    }
}