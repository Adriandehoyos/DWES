import { Router } from "express";
import { actualizarEquipo, allEquipos, crearEquipo, eliminarEquipo, equipoId, heroesPorEquipoId } from "../controllers/equiposController";

const router = Router();

router.get('/equipos', allEquipos);
router.get('/equipos/:id', equipoId);
router.post('/equipos', crearEquipo);
router.put('/equipos/:id', actualizarEquipo);
router.delete('/equipos/:id', eliminarEquipo);
router.get('/equipos/:id/heroes', heroesPorEquipoId);

export default router;