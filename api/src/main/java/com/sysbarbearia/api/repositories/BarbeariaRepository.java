package com.sysbarbearia.api.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sysbarbearia.api.model.*;

@Repository
public interface BarbeariaRepository extends JpaRepository<Barbearia, Integer> {
	
	@Transactional(readOnly = true)
	@Query(value = "SELECT COUTN(*) FROM EMPRESAS" , nativeQuery = true)
    public Collection<?> countEmpresas();
}
