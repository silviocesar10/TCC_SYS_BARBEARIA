package com.sysbarbearia.api.services;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
//import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysbarbearia.api.model.ServicoOferecido;
import com.sysbarbearia.api.model.Cliente;
import com.sysbarbearia.api.model.Uso;
import com.sysbarbearia.api.algorithms.utils.Matrix;

@Service
public class RecomendacaoService {
	@Autowired
	private ClienteService uservice;
	@Autowired
	private UsoService avservice;
	@Autowired
	private ServicoOferecidoService sservice;
	
	private Matrix matrix;
	private Matrix matrixC;
			
	public void recomedacao()
	{
		List<Cliente> allCliente = new ArrayList<Cliente>(uservice.findAll());
		//List<Uso> allUso = new ArrayList<Uso>(avservice.findAll());
		List<ServicoOferecido> allServicos = new ArrayList<ServicoOferecido>(sservice.findByIdBarbearia(1));
		//int tCliente =allCliente.size();
		//int tServicos = allServicos.size();
		//int tAvaliacoes = allUso.size();
		matrix = new Matrix(allCliente.size(), allServicos.size());
		matrixC = new Matrix(allCliente.size(), allServicos.size());
		for(int i = 0; i < allCliente.size(); i++){
		//for(int i = 0; i < 2; i++){
			Cliente u = allCliente.get(i);
			
			for(int j =0; j < allServicos.size(); j++) {
			//for(int j =0; j < 2; j++) {
				ServicoOferecido s = allServicos.get(j);
				//Optional<Uso> o = allUso.stream().filter(a -> a.getServico().getIdServicoOfrc() == s.getIdServicoOfrc() && a.getUsuario().getidCliente() == u.getidCliente()).findFirst();
				Optional<Uso> o = getUsoByServicoByCliente(u, s);
				if(o.isEmpty()){
					//matrix[i][j] = null;
					matrix.setContentByIndex(i, j, null);
					//matrix[i][j] = 1d;
					//matrixC[i][j] = null;
					matrixC.setContentByIndex(i, j, null);
				}else {
					matrix.setContentByIndex(i, j, o.get().getNota());
					matrixC.setContentByIndex(i, j, o.get().getNota());
					//matrix[i][j] = o.get().getNota();
					//matrixC[i][j] = o.get().getNota();
				}
				 
			}
			printContentMatrix(matrix);
		}
		
		
					
 	}
	private Optional<Uso> getUsoByServicoByCliente(Cliente c, ServicoOferecido s){
		List<Uso> allUso = new ArrayList<Uso>(avservice.findAll());
		return allUso.stream().filter(a -> a.getServico().getIdServicoOfrc() == s.getIdServicoOfrc() && a.getUsuario().getidCliente() == c.getidCliente()).findFirst();
	}
	
	private void printContentMatrix(Matrix m) {
		for (int i =0; i < m.getRowSize(); i++) {
			for (int j =0; j < m.getColSize(); j++) {
				System.out.print(m.getContentByIndex(i, j) + "|");
			}
		}
	}
}