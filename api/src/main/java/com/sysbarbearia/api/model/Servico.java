package com.sysbarbearia.api.model;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( of = {"idServoco"})
public class Servico implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idServico;
	

	@OneToMany
	@JoinColumn(name = "idEmpresa")
	private Integer idEmpresa;
	
	@NotBlank(message = "O campo de descricao do livro nao pode permanecer em branco!!")
	@Size(min = 2, max = 200, message = "O campo de descricao deve ter no minimo 2 e no maximo 200 caracteres!!")
	private String descricao;
	
	@NotBlank(message = "o campo nao deve estar vazio")
	private String nomeProdServ;
	 
	@NotBlank(message = "O campo de descricacao nao pode permanecer em branco!!")
	@Size(min = 2, max = 100, message = "O campo descricacao deve ter no minimo 2 e no maximo 100 caracteres!!")
	private String descricacao;
	
	@NotBlank(message = "O campo de preco nao pode permanecer em branco!!")
	private Double preco;

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeProdServ() {
		return nomeProdServ;
	}

	public void setNomeProdServ(String nomeProdServ) {
		this.nomeProdServ = nomeProdServ;
	}

	public String getDescricacao() {
		return descricacao;
	}

	public void setDescricacao(String descricacao) {
		this.descricacao = descricacao;
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
