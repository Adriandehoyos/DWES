import { Router } from "express";
import { actualizarPista, allPistas, crearPista, eliminarPista, pistaPorId } from "../controllers/pistaController";

const router = Router();
router.get('/pistas', allPistas);
router.post('/pistas', crearPista);
router.get('/pistas/:id', pistaPorId);
router.put('/pistas/:id', actualizarPista);
router.delete('/pistas/:id', eliminarPista);
export default router;