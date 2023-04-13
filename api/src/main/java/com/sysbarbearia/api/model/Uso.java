package com.sysbarbearia.api.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;




@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( of = {"idUso"})
public class Uso implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUso;
	
	@OneToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name = "idServicoOfrc")
	private ServicoOferecido servicoofrc;
		
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataAvaliacao;
	
	//@NotBlank(message = "O campo nota nao deve estar vazio")
	@NotNull(message = "O campo nota nao deve estar vazio")
	private Double nota;
	
	//@NotBlank(message = "O campo de preco nao pode permanecer em branco!!")
	@NotNull(message = "O campo de preco nao pode permanecer em branco!!")
	private Double preco;

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getidUso() {
		return idUso;
	}

	public void setidUso(Integer idUso) {
		this.idUso = idUso;
	}

	public Cliente getUsuario() {
		return cliente;
	}

	public void setsuario(Cliente cliente) {
		this.cliente = cliente;
	}

	public ServicoOferecido getServico() {
		return servicoofrc;
	}

	public void setServico(ServicoOferecido servico) {
		this.servicoofrc = servico;
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	
}
