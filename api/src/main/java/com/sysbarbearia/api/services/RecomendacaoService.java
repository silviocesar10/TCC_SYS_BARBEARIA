package com.sysbarbearia.api.services;
//import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;


import com.sysbarbearia.api.algorithms.utils.MatrizSimilaridade;
import com.sysbarbearia.api.algorithms.utils.PosicaoCelula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysbarbearia.api.services.exceptions.BusinessRuleException;
import com.sysbarbearia.api.model.ServicoOferecido;
import com.sysbarbearia.api.model.Cliente;
import com.sysbarbearia.api.model.Uso;
import com.sysbarbearia.api.algorithms.utils.MatrizBasica;

@Service
public class RecomendacaoService {

	private final Double NOTADECORTE = 3.0d;
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ServicoOferecidoService servicoOferecidoService;
	private List<Cliente> allCliente;

	@Autowired
	private RecomendacaoOffilineService recomendacaoOffilineService;

	//@Autowired
	//UsoRepository repo;
	@Autowired
	UsoService usoService;

	public List<ServicoOferecido> recomendacaoCollaborativa(Integer idEmpresa, Integer idCliente) {
		List<Uso> allUso = new ArrayList<Uso>(usoService.findAll());
		allUso.forEach(System.out::println);
		allCliente = new ArrayList<Cliente>(clienteService.findAll());
		List<ServicoOferecido> allServicos = new ArrayList<ServicoOferecido>(servicoOferecidoService.findByIdBarbearia(idEmpresa));
		MatrizBasica mb = new MatrizBasica(allServicos, allCliente, allUso);
		printContentMatrix(mb.getContent(), mb.getRowSize(),  mb.getColSize());
		MatrizSimilaridade ms = new MatrizSimilaridade(mb, encontrarCliente(idCliente, allCliente));
		printContentMatrix(ms.getContent(), ms.getRowSize(),  ms.getColSize());
		ArrayList<PosicaoCelula> pc = new ArrayList<PosicaoCelula>();
		List<ServicoOferecido> lista = calcular(ms.getColSize(), ms.getRowSize(),ms.getContent(),pc, ms.getLinhaUsuario());
		if(lista.isEmpty()){
			throw new BusinessRuleException("Não ha recomendações disponiveis para o usuario alvo " + encontrarCliente(idCliente, allCliente).getNome());
		}
		return lista;
	}

	public List<ServicoOferecido> calcular(int col, int rol, Double [][] m, List<PosicaoCelula> pc, int linhaUsuario){
		int colDistancia = col -2;
		for(int i =0; i < rol; i++){
			for(int j = 0; j < colDistancia; j++){
				if(linhaUsuario == i && m[i][j] == null){
					pc.add(new PosicaoCelula(i, j));
				}
			}
		}
		List<ServicoOferecido> lista = new ArrayList<ServicoOferecido>();
		Integer tmp;
		do{
			for (PosicaoCelula n : pc) {
				tmp = n.getColuna();
				ServicoOferecido s = multiplicar(m, linhaUsuario, tmp, col, rol);
				if (s != null) {
					lista.add(s);
				}

			}
			pc.remove(0);
		}while (pc.size() > 0);
		return lista;

	}
	private ServicoOferecido multiplicar(Double m[][], int linhaUsuario, int col, int colDistancia, int rol){
		Double soma = 0.0d;
		Double simi = 0.0d;
		for (int i = 0 ; i < rol ; i++){
				if(m[i][col] == null){
					soma = soma + 0.0d;
				}else{
					soma += m[i][col] * m[i][colDistancia - 1];
					simi = simi + m[i][colDistancia - 1];
					System.out.println("soma aqui" + soma);
				}


		}
		soma = soma / simi;
		System.out.println("soma aqui" + soma);
		if(soma >= NOTADECORTE){
			System.out.println("vai ser recomendado");
			return servicoOferecidoService.findById(col + 1);
		}
		else
		{
			return null;
		}
	}

	public Cliente encontrarCliente(int id, List<Cliente> l){
		for (Cliente c : l){
			if(c.getidCliente().equals(id)) {
				return c;
			}
		}
		return null;
	}
 public  Boolean clienteEncontrado(int id){
	 if(encontrarCliente(id, allCliente) == null){
		 return true;
	 }
	 return false;
 }

	private void printContentMatrix(Double[][] m, int l, int c) {
		for (int i = 0; i < l; i++) {
			System.out.println();
			for (int j = 0; j < c; j++) {
				System.out.print(m[i][j] + "|");
			}
		}
	}

	public RecomendacaoService(){}

}