import express from "express";
import connectDatabase from "./config/db.js"
import calcularRecomendacoes from "./algorithms/recomendacao.js";

const app = express();

app.get('/', (req, res) => {
  res.send('Hello Express app!')
});

app.listen(3000, () => {
  connectDatabase();
  //calcularRecomendacoes();
  console.log('server started');
});
