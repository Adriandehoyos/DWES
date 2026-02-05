import { Router } from "express";
import { actualizarVillano, allVillanos, crearVillano, eliminarVillano, villanoId, villanosPorAntiequipos } from "../controllers/villanoscontroller";

const router = Router();

router.get('/villanos', allVillanos);
router.get('/villanos/:id', villanoId);
router.post('/villanos', crearVillano);
router.put('/villanos/:id', actualizarVillano);
router.delete('/villanos/:id', eliminarVillano);
router.get('/villanos/antiequipos/:antiequipo_id', villanosPorAntiequipos)

export default router;