package com.sysbarbearia.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import com.sysbarbearia.api.model.*;
import java.util.Collection;

@Repository
public interface AvaliacaoRepository extends JpaRepository <Avaliacao, Integer>{
	
	@Transactional(readOnly = true)
	@Query(value = "SELECT * FROM AVALIACAO avl WHERE avl.ID_USUARIO = ?1" , nativeQuery = true)
    public Collection<?> findAvaliacaoByUsuario(Integer id);

    //@Transactional(readOnly = true)
    //@Query(value = "select c.nome as nome, count(r.valor) as quantidade, l.autor, l.titulo_livro from reserva r, livro l, cliente c where r.id_pessoa = c.id_pessoa and r.id_livro = l.id_livro and DATA_RESERVA > ?1 and DATA_RESERVA < ?2 group by c.nome , l.autor, l.titulo_livro;", nativeQuery = true)
	//public Collection<?> findQuantidadesReservasOfClientesByPeriodo(Date inicio, Date termino);
    
    //@Transactional(readOnly = true)
    //@Query(value = "select c.nome as nome, count(r.valor) as quantidade, l.autor, l.titulo_livro from reserva r, livro l, cliente c where r.id_pessoa = c.id_pessoa group by c.nome , l.autor, l.titulo_livro", nativeQuery = true)
	//public Collection<?> findQuantidadesReservasOfClientes();
    
    //@Transactional(readOnly = true)
    //@Query(value = "SELECT * FROM reserva rsv WHERE rsv.id_pessoa = ?1 AND rsv.data_reserva = ?2 AND rsv.data_reserva = ?3", nativeQuery = true)
    //@Query(value = "SELECT * FROM reserva rsv WHERE rsv.id_pessoa = ?1 AND extract(month FROM rsv.data_reserva) = extract(month FROM (SELECT CURRENT_DATE)) AND extract(year FROM rsv.data_reserva) = extract(year FROM (SELECT CURRENT_DATE))", nativeQuery = true)
    //public Collection<Reserva> findByClienteAndPeriodoInMonth(Integer idCliente);
}
