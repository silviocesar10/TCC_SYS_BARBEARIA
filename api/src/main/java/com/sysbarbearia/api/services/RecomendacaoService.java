package com.sysbarbearia.api.services;
//import java.util.Collection;
import java.util.List;
import java.util.ArrayList;


import com.sysbarbearia.api.algorithms.utils.MatrizSimilaridade;
import com.sysbarbearia.api.model.Uso;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.sysbarbearia.api.repositories.UsoRepository;

import com.sysbarbearia.api.model.ServicoOferecido;
import com.sysbarbearia.api.model.Cliente;
import com.sysbarbearia.api.algorithms.utils.MatrizBasica;

@Service
public class RecomendacaoService {
	@Autowired
	private ClienteService uservice;

	@Autowired
	private ServicoOferecidoService sservice;
	private List<Cliente> allCliente;

	//@Autowired
	//UsoRepository repo;
	@Autowired
	UsoService usoService;
	public void recomendacaoCollaborativa(Integer idEmpresa, Integer idCliente) {
		allCliente = new ArrayList<Cliente>(uservice.findAll());
		List<ServicoOferecido> allServicos = new ArrayList<ServicoOferecido>(sservice.findByIdBarbearia(1));
		//MatrizBasica mb = new MatrizBasica(allServicos, allCliente);
		//if(encontrarCliente(idCliente, allCliente) == null){
		//System.out.println( "O cliente informado não pode ser encontrado para ser avaliado");
		//}
		//MatrizSimilaridade ms = new MatrizSimilaridade(mb, encontrarCliente(idCliente, allCliente));
		//printContentMatrix(ms.getContent(), mb.getRowSize(),  mb.getColSize());
		//UsoService avservice = new UsoService();
		//List<Uso> allUso = new ArrayList<Uso>(avservice.findAll());

		List<Uso> allUso = new ArrayList<Uso>(usoService.findAll());
		allUso.forEach(System.out::println);
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
			for (int j = 0; j < c; j++) {
				System.out.print(m[i][j] + "|");
			}
		}
	}

	public RecomendacaoService(){}

}