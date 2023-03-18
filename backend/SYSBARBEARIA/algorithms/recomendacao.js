import Usuario from "../models/Usuario.js";
import Avaliacao from "../models/Avaliacao.js"
import Servico from "../models/Servico.js"
import connectDatabase from "../config/db.js";
import bcrypt from "bcryptjs";
import Empresa from "../models/Empresa.js";
// Função para calcular a distância Euclidiana entre duas listas de avaliações
function distanciaEuclidiana(avaliacoes1, avaliacoes2) {
  // Criar um objeto para armazenar as avaliações de cada cliente
  const avaliacoes = {};

  // Preencher o objeto com as avaliações do primeiro cliente
  for (let i = 0; i < avaliacoes1.length; i++) {
    avaliacoes[avaliacoes1[i].id_produto] = avaliacoes1[i].nota;
  }

  // Calcular a distância Euclidiana usando as avaliações do segundo cliente
  let distancia = 0;
  for (let i = 0; i < avaliacoes2.length; i++) {
    const produto_id = avaliacoes2[i].id_produto;
    if (avaliacoes[produto_id]) {
      const diferenca = avaliacoes[produto_id] - avaliacoes2[i].nota;
      distancia += diferenca * diferenca;
    }
  }

  // Retorna a diference em uma razao de 1
  return 1/(1 + Math.sqrt(distancia));
}


const calcularRecomendacoes = async(usuarioBase) =>
{
    //await connectDatabase();
    //await populate();
    //var empresa = new Empresa;
    //empresa = Empresa.find();
    //console.log(empresa);
    //total de usuarios e de servicos cadastrados no sistma
    //totalUsuarios = Usuario.count();
    //totalServicos = Servico.count();

    //avalicoesUsuarioBase = Avaliacao.find({usuario : usuarioBase});
    //console.log(avalicoesUsuarioBase);

}
export default calcularRecomendacoes