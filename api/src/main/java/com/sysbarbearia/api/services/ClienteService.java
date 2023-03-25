package com.sysbarbearia.api.services;
import java.util.Collection;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysbarbearia.api.repositories.*;
import com.sysbarbearia.api.model.Cliente;
import com.sysbarbearia.api.services.exceptions.*;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;

	public Cliente findById(Integer id)
	{
		Cliente obj = repository.findById(id).get();
		if(obj == null)
		{
			throw new ObjectNotFoundException("Objeto nao encontrado Id: " + id + ", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}
	
	public Collection<Cliente> findAll()
	{
		return repository.findAll();
	}
	
	public Cliente insert(Cliente obj)
	{
		obj.setidCliente(null);;
		return repository.save(obj);		
	}
	
	public Cliente update(Cliente obj)
	{
		findById(obj.getidCliente());
        try 
        {
        	return repository.save(obj);
        }
        catch (DataIntegrityViolationException e) 
        {
            throw new DataIntegrityException("Campo(s) obrigatório(s) do Usuario não foi(foram) preenchido(s)");
        }
    }
	public void delete(Integer id) 
	{
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir um Usuario");
        }
    }
	public Collection<?> countUsuarios() {
        Collection<?> collection = repository.countUsuarios();
        return collection;
    }
	
}
