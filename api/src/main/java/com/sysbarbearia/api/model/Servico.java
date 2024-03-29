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
		
	@NotBlank(message = "O campo de descricao do livro nao pode permanecer em branco!!")
	@Size(min = 2, max = 200, message = "O campo de descricao deve ter no minimo 2 e no maximo 200 caracteres!!")
	private String descricao;
	
	@NotBlank(message = "o campo nao deve estar vazio")
	private String nomeProdServ;
	

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
