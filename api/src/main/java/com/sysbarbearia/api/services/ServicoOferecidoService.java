package com.sysbarbearia.api.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sysbarbearia.api.model.ServicoOferecido;
import com.sysbarbearia.api.repositories.ServicoOferecidoRepository;
import com.sysbarbearia.api.services.exceptions.DataIntegrityException;
import com.sysbarbearia.api.services.exceptions.ObjectNotFoundException;

@Service
public class ServicoOferecidoService {
	@Autowired
	private ServicoOferecidoRepository repository;

	public ServicoOferecido findById(Integer id)
	{
		ServicoOferecido obj = repository.findById(id).get();
		if(obj == null)
		{
			throw new ObjectNotFoundException("Objeto nao encontrado Id: " + id + ", Tipo: " + ServicoOferecido.class.getName());
		}
		return obj;
	}
	
	public Collection<ServicoOferecido> findAll()
	{
		return repository.findAll();
	}
	
	public ServicoOferecido insert(ServicoOferecido obj)
	{
		obj.setIdServicoOfrc(null);;;
		return repository.save(obj);		
	}
	
	public ServicoOferecido update(ServicoOferecido obj)
	{
		findById(obj.getIdServicoOfrc());
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
	public Collection<?> countServicosOferecidos() {
        Collection<?> collection = repository.countServicosOferecidos();
        return collection;
    }
}
