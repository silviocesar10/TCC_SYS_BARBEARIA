package com.sysbarbearia.api.services;
//import java.util.Collection;
import java.util.List;
import java.util.ArrayList;


import com.sysbarbearia.api.algorithms.utils.MatrizSimilaridade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sysbarbearia.api.model.ServicoOferecido;
import com.sysbarbearia.api.model.Cliente;
import com.sysbarbearia.api.model.Uso;
import com.sysbarbearia.api.algorithms.utils.MatrizBasica;

@Service
public class RecomendacaoService {
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ServicoOferecidoService servicoOferecidoService;
	private List<Cliente> allCliente;

	//@Autowired
	//UsoRepository repo;
	@Autowired
	UsoService usoService;
	public void recomendacaoCollaborativa(Integer idEmpresa, Integer idCliente) {
		List<Uso> allUso = new ArrayList<Uso>(usoService.findAll());
		allUso.forEach(System.out::println);
		allCliente = new ArrayList<Cliente>(clienteService.findAll());
		List<ServicoOferecido> allServicos = new ArrayList<ServicoOferecido>(servicoOferecidoService.findByIdBarbearia(1));
		MatrizBasica mb = new MatrizBasica(allServicos, allCliente, allUso);
		printContentMatrix(mb.getContent(), mb.getRowSize(),  mb.getColSize());
		//if(encontrarCliente(idCliente, allCliente) == null){
		//System.out.println( "O cliente informado não pode ser encontrado para ser avaliado");
		//}
			MatrizSimilaridade ms = new MatrizSimilaridade(mb, encontrarCliente(1, allCliente));
		//printContentMatrix(ms.getContent(), mb.getRowSize(),  mb.getColSize());


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