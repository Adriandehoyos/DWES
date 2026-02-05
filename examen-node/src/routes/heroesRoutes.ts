import { Router } from "express";
import { actualizarHeroe, allHeroes, crearHeroe, eliminarHeroe, heroeId, heroesPorEquipo } from "../controllers/heroesController";

const router = Router();

router.get('/heroes', allHeroes);
router.get('/heroes/:id', heroeId);
router.post('/heroes', crearHeroe);
router.put('/heroes/:id', actualizarHeroe);
router.delete('/heroes/:id', eliminarHeroe);
router.get('/heroes/equipos/:equipo_id', heroesPorEquipo)

export default router;