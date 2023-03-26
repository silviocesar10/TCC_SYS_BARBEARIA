package com.sysbarbearia.api.model;

import lombok.*;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( of = {"idBarbearia"})
public class Barbearia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBarbearia;
	
	@NotBlank(message = "O campo com o titulo do nome nao pode permanecer em branco!!")
	@Size(min = 2, max = 50, message = "O campo de titulo deve ter no minimo 2 e no maximo 50 caracteres!!")
	private String nome;
	
	@NotBlank(message = "O campo de descricao do email nao pode permanecer em branco!!")
	@Size(min = 2, max = 100, message = "O campo de descricao deve ter no minimo 2 e no maximo 200 caracteres!!")
	private String email;
	
	@NotBlank(message = "o campo deve conter um registro ISBN referente a obra cadastrada")
	private String senha;
	 
	@NotBlank(message = "O campo de nome do cnpj nao pode permanecer em branco!!")
	private String cnpj;
	 
	@NotBlank(message = "o campo telefone nao deve estar vazio")
	private String telefone;
	
	@NotBlank(message = "o campo endereco nao deve estar vazio")
	private String endereco;
	
	@NotBlank(message = "o campo descricacao nao deve estar vazio")
	private String descricao;

	public Integer getIdEmpresa() {
		return idBarbearia;
	}

	public void setIdEmpresa(Integer idBarbearia) {
		this.idBarbearia = idBarbearia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
