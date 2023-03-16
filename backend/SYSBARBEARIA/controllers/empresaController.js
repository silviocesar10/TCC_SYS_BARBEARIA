import Empresa from "../models/Empresa.js";

export const createEmpresa = async (req, res, next) => {
    const empresa = new Empresa(req.body);
    try {
        const createdEmpresa = await empresa.save();
        res.status(201).json(createdEmpresa);
    } catch (error) {
        next(error);
    }
};
export const updateEmpresa = async (req, res, next) => {
    try {
        const updatedEmpresa = await Empresa.findByIdAndUpdate(req.params.id, {
            $set:
                req.body
        }, { new: true });
        res.status(200).json(updatedEmpresa);
    } catch (error) {
        next(error);
    }
};
export const deleteEmpresa = async (req, res, next) => {
    try {
        await Empresa.findByIdAndDelete(req.params.id);
        res.status(200).json({ message: "Empresa excluído com sucesso." });
    } catch (error) {
        next(error);
    }
};
export const getEmpresa = async (req, res, next) => {
    try {
        const empresa = await Empresa.findById(req.params.id);
        res.status(200).json(empresa);
    } catch (error) {
        next(error);
    }
};
export const getEmpresas = async (req, res, next) => {
    try {
        const empresas = await Empresa.find();
        res.status(200).json(empresas);
    } catch (error) {
        next(error);
    }
};