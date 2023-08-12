package com.sysbarbearia.api.model;
import lombok.*;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"idCliente"})
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	 
	@Column(length = 50)
	@NotNull(message = "O nome nao deve ficar em branco")
	@Size(min = 2, max = 50, message = "O nome deve ter entre 2 e 50 letras")
	private String nome;

	@Column(length = 50)
	@NotNull(message = "A senha nao deve ficar em branco")
	@Size(min = 2, max = 50, message = "A senha deve ter entre 2 e 50 letras")
	private String senha;

	@NotBlank(message = "O campo da encereco deve ser preenchido")
    @Size(min = 2, max = 100, message = "O campo endereco deve ter entre 2 e 100 letras")  
	private String endereco;
	
	@Column(length = 50)
	@NotNull
    @NotBlank(message = "CPF da Pessoa deve ser preenchido")
    @Size(min = 2, max = 50, message = "CPF da Pessoa deve ter entre 2 e 50 letras")
    @Pattern(regexp="\\d{3}.\\d{3}.\\d{3}-\\d{2}", message = "CPF da Pessoa deve seguir o padrão NNN.NNN.NNN-NN")
	private String cpf;
	
	@NotNull
	@NotBlank(message = "O campo de telefone nao deve estar vazio!!")
	private String telefone;

	public Integer getidCliente() {
		return idCliente;
	}

	public void setidCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
