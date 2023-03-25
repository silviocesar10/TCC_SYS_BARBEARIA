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

import com.sysbarbearia.api.model.Barbearia;
import com.sysbarbearia.api.services.EmpresaService;
import com.sysbarbearia.api.services.exceptions.ConstraintException;

@RestController
@RequestMapping(value = "/servicosoferecidos")
public class ServicoOferecidoController {
	@Autowired
	private EmpresaService service;
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Barbearia>> findAll() {
        Collection<Barbearia> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Barbearia> find(@PathVariable Integer id) {
        Barbearia obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
        
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Barbearia> insert(@Valid @RequestBody Barbearia obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Barbearia> update(@Valid @RequestBody Barbearia obj, BindingResult br) {
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
