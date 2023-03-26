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

import com.sysbarbearia.api.model.Uso;
import com.sysbarbearia.api.services.UsoService;
import com.sysbarbearia.api.services.exceptions.*;

@RestController
@RequestMapping(value = "/usos")
public class UsoController {
	@Autowired
    private UsoService service;
 	

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Uso>> findAll() {
        Collection<Uso> collection = service.findAll();
        return ResponseEntity.ok().body(collection);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Uso> find(@PathVariable Integer id) {
        Uso obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Uso> insert(@Valid @RequestBody Uso obj, BindingResult br) {
        if (br.hasErrors())
        	throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
        obj = service.insert(obj);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Uso> update(@Valid @RequestBody Uso obj, BindingResult br) {
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
    
	@RequestMapping(value = "/findAavaliacaoByUsuario/{id}", method = RequestMethod.GET)
		public ResponseEntity<Collection<?>> findAvaliacaoByUsuario(Integer id){
			Collection<?> collection = service.findAvaliacaoByUsuario(id);
			return ResponseEntity.ok().body(collection);
		}
	
}
