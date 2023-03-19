import express from "express";
import { createUsuario, updateUsuario, deleteUsuario, getUsuario, getUsuarios } from "../controllers/empresaController.js";
//import { verificarToken } from "../utils/verificarToken.js";
const router = express.Router();

//router.post("/", verificarToken, createUsuario);
//router.put("/:id", verificarToken, updateUsuario);
//router.delete("/:id", verificarToken, deleteUsuario);
//router.get("/:id", verificarToken, getUsuario);
//router.get("/", verificarToken, getUsuarios);

router.post("/", createUsuario);
router.put("/:id", updateUsuario);
router.delete("/:id", deleteUsuario);
router.get("/:id", getUsuario);
router.get("/", getUsuarios);
export default router;