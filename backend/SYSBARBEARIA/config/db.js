import mongoose from "mongoose";
//import Aluno from "../models/Aluno.js";
import bcrypt from "bcryptjs";

const connectDatabase = async () => {
    try {
        //await mongoose.connect(process.env.MONGODB_URL_LOCAL);
        await mongoose.connect("mongodb://127.0.0.1:27017/recomendacao");
    } catch (error) {
        throw error;
    }
};

mongoose.connection.on("disconnected", async () => {
    console.log("Desconectado do MongoDB.");
});

mongoose.connection.on("connected", async () => {
    //await populateDatabase();
    console.log("Conectado ao MongoDB.");
});

mongoose.connection.on("error", async (error) => {
    console.log(`Erro no MongoDB:\n${error}`);
});

export default connectDatabase;