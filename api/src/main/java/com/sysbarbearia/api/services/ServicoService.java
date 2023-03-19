package com.sysbarbearia.api.services;

import java.util.Collection;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysbarbearia.api.model.*;
import com.sysbarbearia.api.repositories.*;
import com.sysbarbearia.api.services.exceptions.*;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository repository;

	public Servico findById(Integer id)
	{
		Servico obj = repository.findById(id).get();
		if(obj == null)
		{
			throw new ObjectNotFoundException("Objeto nao encontrado Id: " + id + ", Tipo: " + Servico.class.getName());
		}
		return obj;
	}
	
	public Collection<Servico> findAll()
	{
		return repository.findAll();
	}
	
	public Servico insert(Servico obj)
	{
		obj.setIdServico(null);
		return repository.save(obj);	
	}
	
	public Servico update(Servico obj)
	{
		findById(obj.getIdServico());
        try 
        {
        	return repository.save(obj);
        }
        catch (DataIntegrityViolationException e) 
        {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Servico não foi(foram) preenchido(s)");
        }
    }
	public void delete(Integer id) 
	{
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um Servico associado a Reservas");
        }
    }
	public Collection<?> countServicos() {
        Collection<?> collection = repository.countServicos();
        return collection;
    }
}
