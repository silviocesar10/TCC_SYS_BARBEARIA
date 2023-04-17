package com.sysbarbearia.api.services;
import java.util.List;
import java.util.ArrayList;


import com.sysbarbearia.api.algorithms.utils.MatrizSimilaridade;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysbarbearia.api.model.ServicoOferecido;
import com.sysbarbearia.api.model.Cliente;
import com.sysbarbearia.api.algorithms.utils.MatrizBasica;

@Service
public class RecomendacaoService {
	@Autowired
	private ClienteService uservice;

	@Autowired
	private ServicoOferecidoService sservice;
	private List<Cliente> allCliente = new ArrayList<Cliente>(uservice.findAll());


	public void recomendacaoCollaborativa(int idEmpresa, int idCliente) {
		List<ServicoOferecido> allServicos = new ArrayList<ServicoOferecido>(sservice.findByIdBarbearia(idEmpresa));
		MatrizBasica mb = new MatrizBasica(allServicos, allCliente);
		if(encontrarCliente(idCliente, allCliente) == null){
			System.out.println( "O cliente informado não pode ser encontrado para ser avaliado");
		}
		MatrizSimilaridade ms = new MatrizSimilaridade(mb, encontrarCliente(idCliente, allCliente));
		printContentMatrix(ms.getContent(), mb.getRowSize(),  mb.getColSize());

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

}