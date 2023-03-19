package com.sysbarbearia.api.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sysbarbearia.api.model.*;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
	@Transactional(readOnly = true)
	@Query(value = "SELECT COUTN(*) FROM SERVICOS" , nativeQuery = true)
    public Collection<?> countServicos();
}
