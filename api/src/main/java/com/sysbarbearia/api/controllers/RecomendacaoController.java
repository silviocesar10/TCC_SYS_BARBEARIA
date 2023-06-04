package com.sysbarbearia.api.controllers;

import com.sysbarbearia.api.model.ServicoOferecido;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

//import com.sysbarbearia.api.model.Servico;
import com.sysbarbearia.api.services.RecomendacaoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping(value = "/recomendacao")	
public class RecomendacaoController {
	@Autowired
	private RecomendacaoService s;
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<ServicoOferecido>> get(@RequestParam("idCliente") Integer idCliente, @RequestParam("idEmpresa") Integer idEmpresa) {
		List<ServicoOferecido> resultado = s.recomendacaoCollaborativa(idEmpresa, idCliente);
		return ResponseEntity.ok(resultado);
	}
	       
}
