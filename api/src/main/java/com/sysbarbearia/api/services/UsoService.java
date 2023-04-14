package com.sysbarbearia.api.services;

import java.util.Collection;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysbarbearia.api.model.*;
import com.sysbarbearia.api.repositories.UsoRepository;
import com.sysbarbearia.api.services.exceptions.*;

@Service
public class UsoService {
	@Autowired
	private UsoRepository repository;

	public Uso findById(Integer id)
	{
		Uso obj = repository.findById(id).get();
		if(obj == null)
		{
			throw new ObjectNotFoundException("Objeto nao encontrado Id: " + id + ", Tipo: " + Uso.class.getName());
		}
		return obj;
	}
	
	public Collection<Uso> findAll()
	{
		return repository.findAll();
	}
	
	public Uso insert(Uso obj)
	{
		obj.setIdUso(null);
		return repository.save(obj);	
	}
	
	public Uso update(Uso obj)
	{
		findById(obj.getIdUso());
        try 
        {
        	return repository.save(obj);
        }
        catch (DataIntegrityViolationException e) 
        {
            throw new DataIntegrityException("Campo(s) obrigatório(s) de Avaliacao não foram preenchido(s)");
        }
    }
	public void delete(Integer id) 
	{
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma Avaliacao");
        }
    }
    
	public Collection<?> findAvaliacaoByUsuario(Integer id) {
        Collection<?> collection = repository.findAvaliacaoByUsuario(id);
        return collection;
    }
}
