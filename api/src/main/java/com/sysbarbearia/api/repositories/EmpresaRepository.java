package com.sysbarbearia.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sysbarbearia.api.model.*;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

}
