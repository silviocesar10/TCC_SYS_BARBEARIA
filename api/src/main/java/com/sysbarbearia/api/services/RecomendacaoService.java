package com.sysbarbearia.api.services;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysbarbearia.api.services.*;
import com.sysbarbearia.api.model.*;

@Service
public class RecomendacaoService {
	@Autowired
	private UsuarioService uservice;
	@Autowired
	private AvaliacaoService avservice;
	@Autowired
	private ServicoService sservice;
	
	private Double[][] matrix;
	private Double[][] matrixC;
			
	public void recomedacao()
	{
		List<Usuario> allUsuario = new ArrayList<Usuario>(uservice.findAll());
		List<Avaliacao> allAvaliacao = new ArrayList<Avaliacao>(avservice.findAll());
		List<Servico> allServicos = new ArrayList<Servico>(sservice.findAll()); 
		int tUsuario =allUsuario.size();
		int tServicos = allServicos.size();
		//int tAvaliacoes = allAvaliacao.size();
		matrix = new Double[tUsuario][tServicos];
		matrixC = new Double[tUsuario][tServicos];
		for(int i = 0; i < tUsuario; i++){
			Usuario u = allUsuario.get(i);
			
			for(int j =0; j < tServicos; j++) {
				Servico s = allServicos.get(j);
				Optional<Avaliacao> o = allAvaliacao.stream().filter(a -> a.getServico().getIdServico() == s.getIdServico() && a.getUsuario().getIdUsuario() == u.getIdUsuario()).findFirst();
				if(o.isEmpty()){
					matrix[i][j] = null;
					matrixC[i][j] = null;
				}else {
					matrix[i][j] = o.get().getNota();
					matrixC[i][j] = o.get().getNota();
				}
				 
			}
		}
		
		for(int i = 0; i < tUsuario; i++){
			System.out.println();
			for(int j =0; j < tServicos; j++) {
				System.out.print(matrix[i][j] + "|");
				
			}
		}
					
 	}
}
