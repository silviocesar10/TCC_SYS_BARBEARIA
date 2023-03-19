package com.sysbarbearia.api.services;
import com.sysbarbearia.api.repositories.*;
import com.sysbarbearia.api.model.*;
import com.sysbarbearia.api.services.exceptions.*;

import java.util.Collection;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
	@Autowired
	private EmpresaRepository repository;

	public Empresa findById(Integer id)
	{
		Empresa obj = repository.findById(id).get();
		if(obj == null)
		{
			throw new ObjectNotFoundException("Objeto nao encontrado Id: " + id + ", Tipo: " + Empresa.class.getName());
		}
		return obj;
	}
	
	public Collection<Empresa> findAll()
	{
		return repository.findAll();
	}
	
	public Empresa insert(Empresa obj)
	{
		obj.setIdEmpresa(null);
		return repository.save(obj);	
			
	}
	
	public Empresa update(Empresa obj)
	{
		findById(obj.getIdEmpresa());
        try 
        {
        	return repository.save(obj);
        }
        catch (DataIntegrityViolationException e) 
        {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Empresa não foi(foram) preenchido(s)");
        }
    }
	public void delete(Integer id) 
	{
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir");
        }
    }
	public Collection<?> countEmpresas() {
        Collection<?> collection = repository.countEmpresas();
        return collection;
    }
	
}
