import Usuario from "../models/Usuario.js";

import bcrypt from "bcryptjs";
import { createError } from "../utils/error.js";

export const createluno = async (req, res, next) => {
    const confSenha = req.body.confSenha;
    const usuario = new Usuario(req.body);
    try {
        if (usuario.senha != confSenha) {
            createError({ statusCode: 400, message: "As senhas não conferem." });
        } else {
            let salt = await bcrypt.genSalt(10);
            let hashSenha = await bcrypt.hash(usuario.senha, salt);
            usuario.senha = hashSenha;
            const createdUsuario = await usuario.save();
            console.log("Usuario criado: ", createdUsuario);
            res.status(201).json(createdUsuario);
        }
    } catch (error) {
        next(error);
    }
};
export const updateUsuario = async (req, res, next) => {
    try {
        const updatedUsuario = await Usuario.findByIdAndUpdate(req.params.id, {
            $set:
                req.body
        }, { new: true });
        res.status(200).json(updatedUsuario);
    } catch (error) {
        next(error);
    }
};
export const deleteUsuario = async (req, res, next) => {
    try {
        await Usuario.findByIdAndDelete(req.params.id);
        res.status(200).json({ message: "Usuario excluído com sucesso." });
    } catch (error) {
        next(error);
    }
};
export const getUsuario = async (req, res, next) => {
    try {
        const usuario = await Usuario.findById(req.params.id);
        res.status(200).json(usuario);
    } catch (error) {
        next(error);
    }
};
export const getUsuarios = async (req, res, next) => {
    try {
        const usuarios = await Usuario.find();
        res.status(200).json(usuarios);
    } catch (error) {
        next(error);
    }
};