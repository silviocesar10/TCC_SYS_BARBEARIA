package com.sysbarbearia.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
//import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class ServicoOferecido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idServicoOfrc;
	
	@OneToOne
	@JoinColumn(name = "idBarbearia")
	private Barbearia barbearia;
	
	@OneToOne
	@JoinColumn(name = "idServico")
	private Servico servico;
	
	//@NotBlank(message = "O campo de preco nao pode permanecer em branco!!")
	private Double preco;

	public Integer getIdServicoOfrc() {
		return idServicoOfrc;
	}

	public void setIdServicoOfrc(Integer idServicoOfrc) {
		this.idServicoOfrc = idServicoOfrc;
	}

	public Barbearia getBarbearia() {
		return barbearia;
	}

	public void setBarbearia(Barbearia barbearia) {
		this.barbearia = barbearia;
	}

	

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
