import { Router } from "express";
import { 
  allPrestamos, 
  crearPrestamo, 
  eliminarPrestamo, 
  prestamoPorId, 
  prestamosPorUsuario,
} from "../controllers/prestamoController";

const router = Router();

// Rutas para préstamos (solo GET, POST y DELETE)
router.get('/prestamos', allPrestamos);
router.post('/prestamos', crearPrestamo);
router.delete('/prestamos/:id', eliminarPrestamo);
router.get('/prestamos/usuario/:usuario_id', prestamosPorUsuario);
router.get('/prestamos/:id', prestamoPorId);



export default router;