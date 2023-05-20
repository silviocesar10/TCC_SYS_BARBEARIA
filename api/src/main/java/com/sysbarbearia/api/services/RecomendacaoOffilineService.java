package com.sysbarbearia.api.services;


import com.sysbarbearia.api.model.Recomendacao;
import com.sysbarbearia.api.repositories.RecomendacaoRepository;
import com.sysbarbearia.api.services.exceptions.DataIntegrityException;
import com.sysbarbearia.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Collection;

public class RecomendacaoOffilineService {

    @Autowired
    private RecomendacaoRepository repository;
    public Recomendacao findById(Integer id)
    {
        Recomendacao obj = repository.findById(id).get();
        if(obj == null)
        {
            throw new ObjectNotFoundException("Objeto nao encontrado Id: " + id + ", Tipo: " + Recomendacao.class.getName());
        }
        return obj;
    }

    public Collection<Recomendacao> findAll()
    {
        return repository.findAll();
    }

    public Recomendacao insert(Recomendacao obj)
    {
        obj.setIdRecomendacao(null);;
        return repository.save(obj);

    }

    public Recomendacao update(Recomendacao obj)
    {
        findById(obj.getIdRecomendacao());
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

}
