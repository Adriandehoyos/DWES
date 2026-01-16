import { Router } from "express";
import { allReservas, crearReserva, eliminarReserva } from "../controllers/reservaController";

const router = Router();
router.get('/reservas', allReservas );
router.post('/reservas',crearReserva );
router.delete('/reservas/:id',eliminarReserva );
export default router;