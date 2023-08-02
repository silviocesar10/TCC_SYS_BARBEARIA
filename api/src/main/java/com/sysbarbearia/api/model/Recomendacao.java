package com.sysbarbearia.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@AllArgsConstructor
@EqualsAndHashCode(of = {"idRecomendacao"})
public class Recomendacao implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecomendacao;

    @OneToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = " idServicoOfrc")
    private ServicoOferecido servicoOferecido;

    private LocalDateTime data;

    public Recomendacao() {
    }

    public Integer getIdRecomendacao() {
        return idRecomendacao;
    }

    public void setIdRecomendacao(Integer idRecomendacao) {
        this.idRecomendacao = idRecomendacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ServicoOferecido getServicoOferecido() {
        return servicoOferecido;
    }

    public void setServicoOferecido(ServicoOferecido servicoOferecido) {
        this.servicoOferecido = servicoOferecido;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.data = LocalDateTime.now().toLocalDate().atStartOfDay();
    }
}
