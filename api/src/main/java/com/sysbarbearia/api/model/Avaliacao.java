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
@EqualsAndHashCode( of = {"idAvaliacao"})
public class Avaliacao implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAvaliacao;
	
	@OneToOne
	@JoinColumn(name = "idUsuario")
	private Usuario Usuario;
	
	@OneToOne
	@JoinColumn(name = "idServico")
	private Servico Servico;
		
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataAvalicao;
	
	@NotBlank(message = "O campo nota nao deve estar vazio")
	private Double nota;

	public Integer getIdAvaliacao() {
		return idAvaliacao;
	}

	public void setIdAvaliacao(Integer idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setsuario(Usuario Usuario) {
		this.Usuario = Usuario;
	}

	public Servico getServico() {
		return Servico;
	}

	public void setServico(Servico Servico) {
		this.Servico = Servico;
	}

	public Date getDataAvalicao() {
		return dataAvalicao;
	}

	public void setDataAvalicao(Date dataAvalicao) {
		this.dataAvalicao = dataAvalicao;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	
}
