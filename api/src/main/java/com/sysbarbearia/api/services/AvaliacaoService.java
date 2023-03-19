package com.sysbarbearia.api.services;

import java.util.Collection;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysbarbearia.api.model.*;
import com.sysbarbearia.api.repositories.AvaliacaoRepository;
import com.sysbarbearia.api.services.exceptions.*;

@Service
public class AvaliacaoService {
	@Autowired
	private AvaliacaoRepository repository;

	public Avaliacao findById(Integer id)
	{
		Avaliacao obj = repository.findById(id).get();
		if(obj == null)
		{
			throw new ObjectNotFoundException("Objeto nao encontrado Id: " + id + ", Tipo: " + Avaliacao.class.getName());
		}
		return obj;
	}
	
	public Collection<Avaliacao> findAll()
	{
		return repository.findAll();
	}
	
	public Avaliacao insert(Avaliacao obj)
	{
		obj.setIdAvaliacao(null);
		return repository.save(obj);	
	}
	
	public Avaliacao update(Avaliacao obj)
	{
		findById(obj.getIdAvaliacao());
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
