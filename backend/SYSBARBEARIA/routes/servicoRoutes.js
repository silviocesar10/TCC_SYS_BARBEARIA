import express from "express";
import { createServico, updateServico, deleteServico, getServico, getServicos } from "../controllers/empresaController.js";
//import { verificarToken } from "../utils/verificarToken.js";
const router = express.Router();

//router.post("/", verificarToken, createServico);
//router.put("/:id", verificarToken, updateServico);
//router.delete("/:id", verificarToken, deleteServico);
//router.get("/:id", verificarToken, getServico);
//router.get("/", verificarToken, getServicos);

router.post("/", createServico);
router.put("/:id", updateServico);
router.delete("/:id", deleteServico);
router.get("/:id", getServico);
router.get("/", getServicos);
export default router;