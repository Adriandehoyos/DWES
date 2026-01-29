import { Router } from "express";
import { 
  actualizarUsuario, 
  allUsuarios, 
  crearUsuario, 
  eliminarUsuario, 
  usuarioPorId 
} from "../controllers/usuarioController";

const router = Router();

// Definimos las rutas para usuarios
router.get('/usuarios', allUsuarios);
router.post('/usuarios', crearUsuario);
router.get('/usuarios/:id', usuarioPorId);
router.put('/usuarios/:id', actualizarUsuario);
router.delete('/usuarios/:id', eliminarUsuario);

export default router;