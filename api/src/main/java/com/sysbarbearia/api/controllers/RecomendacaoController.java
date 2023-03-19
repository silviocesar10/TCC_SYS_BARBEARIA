package com.sysbarbearia.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sysbarbearia.api.model.Servico;
import com.sysbarbearia.api.services.RecomendacaoService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(value = "/recomendacao")	
public class RecomendacaoController {
	@Autowired
	private RecomendacaoService s;
	@RequestMapping( method = RequestMethod.GET)
	    public ResponseEntity<Void> get() {
	    	s.recomedacao();
	        return ResponseEntity.noContent().build();
	    }
	       
}
