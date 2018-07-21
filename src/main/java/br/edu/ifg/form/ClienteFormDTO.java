package br.edu.ifg.form;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class ClienteFormDTO  implements Serializable{
	
private static final long serialVersionUID = 8984832253102853707L;
	
	private Integer id;
	
	
	private Integer cpf;
		
	
	private String endereco;
	
	@NotNull
	private String nome;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dt_cad;
	
	
	private String telefone;
	
	public ClienteFormDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDt_cad() {
		return dt_cad;
	}

	public void setDt_cad(Date dt_cad) {
		this.dt_cad = dt_cad;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
