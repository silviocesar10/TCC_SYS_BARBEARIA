package com.sysbarbearia.api.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sysbarbearia.api.model.ServicoOferecido;

public interface ServicoOferecidoRepository extends JpaRepository<ServicoOferecido, Integer> {
	@Transactional(readOnly = true)
	@Query(value = "SELECT COUNT(*) FROM SERVICO_OFERECIDO" , nativeQuery = true)
    public Collection<?> countServicosOferecidos();
	
	@Transactional(readOnly = true)
	@Query(value = "SELECT * FROM SERVICO_OFERECIDO sofc WHERE sofc.ID_BARBEARIA = ?1" , nativeQuery = true)
	public Collection<ServicoOferecido> findByIdBarbearia(Integer id);
}
