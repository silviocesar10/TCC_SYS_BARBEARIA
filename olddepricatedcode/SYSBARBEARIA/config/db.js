import mongoose from "mongoose";
//import Aluno from "../models/Aluno.js";
import Empresa from "../models/Empresa.js"
import Servico from "../models/Servico.js";
import bcrypt from "bcryptjs";

const connectDatabase = async () => {
    try {
        //await mongoose.connect(process.env.MONGODB_URL_LOCAL);
        await mongoose.connect("mongodb://127.0.0.1:27017/recomendacao");
    } catch (error) {
        throw error;
    }
};

const populateDatabase = async () => {
    //const empresa1 = [
        //{
        //nome_empresa: "EmpresaDemo1",
        //email: "empresademo1@email.com",
        //senha: await bcrypt.hash("123456", 10),
        //cnpj: "11111111111",
        //descricao: "barbearia familiar",
        //telefone: "28999998888",
        //endereco :"cachoeiro",
        //cep : "29300500"
        //},
        //{
         // nome_empresa: "EmpresaDemo2",
          //email: "empresademo2@email.com",
          //senha: await bcrypt.hash("123456", 10),
          //cnpj: "11111111221",
          //descricao: "barbearia familiar",
          //telefone: "28999998888",
          //endereco :"cachoeiro",
          //cep : "29300500"
         // },
    //]
    //if((await Empresa.countDocuments({}) == 0)){
      //await Empresa.insertMany(empresa1);
      //console.log("empresas cadastradas")
    //} 
    const servicos =[
        {
            empresa : "64149e11fd03c817b63c842a" ,
            nome_prod_serv : "servico 1",
            descricao : "servico 1",
            preco : 10,
            tempo_estimado : 1
        },
        {
            empresa : "64149e11fd03c817b63c842a" ,
            nome_prod_serv : "servico 2",
            descricao : "servico 2",
            preco : 10,
            tempo_estimado : 1
        },
    ]
    if((await Servico.countDocuments({}) == 0)){
        await Servico.insertMany(servicos);
        console.log("empresas cadastradas")
      }                             
  }
  


mongoose.connection.on("disconnected", async () => {
    console.log("Desconectado do MongoDB.");
});

mongoose.connection.on("connected", async () => {
    await populateDatabase();
    var a = await Empresa.findOne();
    console.log(a)
    var b = await Servico.findOne();
    console.log(b)
    console.log("Conectado ao MongoDB.");
});

mongoose.connection.on("error", async (error) => {
    console.log(`Erro no MongoDB:\n${error}`);
});

export default connectDatabase;