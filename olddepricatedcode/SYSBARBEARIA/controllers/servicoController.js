import Servico from "../models/Servico.js";

export const createServico = async (req, res, next) => {
    const servico = new Servico(req.body);
    try {
        const createdServico = await servico.save();
        res.status(201).json(createdServico);
    } catch (error) {
        next(error);
    }
};
export const updateServico = async (req, res, next) => {
    try {
        const updatedServico = await Servico.findByIdAndUpdate(req.params.id, {
            $set:
                req.body
        }, { new: true });
        res.status(200).json(updatedServico);
    } catch (error) {
        next(error);
    }
};
export const deleteServico = async (req, res, next) => {
    try {
        await Servico.findByIdAndDelete(req.params.id);
        res.status(200).json({ message: "Servico excluído com sucesso." });
    } catch (error) {
        next(error);
    }
};
export const getServico = async (req, res, next) => {
    try {
        const servico = await Servico.findById(req.params.id);
        res.status(200).json(servico);
    } catch (error) {
        next(error);
    }
};
export const getServicos = async (req, res, next) => {
    try {
        const servicos = await Servico.find();
        res.status(200).json(servicos);
    } catch (error) {
        next(error);
    }
};