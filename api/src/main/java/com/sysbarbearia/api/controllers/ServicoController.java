package com.sysbarbearia.api.controllers;


import java.util.Collection;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sysbarbearia.api.services.ServicoService;
import com.sysbarbearia.api.model.Servico;
import com.sysbarbearia.api.services.exceptions.*;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoController {
	@Autowired
	private ServicoService service;
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Servico>> findAll() {
        Collection<Servico> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Servico> find(@PathVariable Integer id) {
        Servico obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
        
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Servico> insert(@Valid @RequestBody Servico obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Servico> update(@Valid @RequestBody Servico obj, BindingResult br) {
    	if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
