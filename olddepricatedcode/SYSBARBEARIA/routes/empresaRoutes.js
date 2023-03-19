import express from "express";
import { createEmpresa, updateEmpresa, deleteEmpresa, getEmpresa, getEmpresas } from "../controllers/empresaController.js";
//import { verificarToken } from "../utils/verificarToken.js";
const router = express.Router();

//router.post("/", verificarToken, createEmpresa);
//router.put("/:id", verificarToken, updateEmpresa);
//router.delete("/:id", verificarToken, deleteEmpresa);
//router.get("/:id", verificarToken, getEmpresa);
//router.get("/", verificarToken, getEmpresas);

router.post("/", createEmpresa);
router.put("/:id", updateEmpresa);
router.delete("/:id", deleteEmpresa);
router.get("/:id", getEmpresa);
router.get("/", getEmpresas);
export default router;