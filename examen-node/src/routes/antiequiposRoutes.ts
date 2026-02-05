import { Router } from "express";
import { actualizarAEquipo, allAntiequipos, antiEquipoId, crearAEquipo, eliminarAEquipo } from "../controllers/antiequiposController";


const router = Router();

router.get('/antiequipos', allAntiequipos);
router.get('/antiequipos/:id', antiEquipoId);
router.post('/antiequipos', crearAEquipo);
router.put('/antiequipos/:id', actualizarAEquipo );
router.delete('/antiequipos/:id', eliminarAEquipo);

export default router;