package com.sysbarbearia.api.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sysbarbearia.api.model.ServicoOferecido;

public interface ServicoOferecidoRepository extends JpaRepository<ServicoOferecido, Integer> {
	@Transactional(readOnly = true)
	@Query(value = "SELECT COUTN(*) FROM SERVICOSOFERECIDOS" , nativeQuery = true)
    public Collection<?> countServicosOferecidos();
}
