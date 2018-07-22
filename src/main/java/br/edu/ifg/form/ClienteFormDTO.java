package br.edu.ifg.form;

import java.io.Serializable;
//import java.util.Date;

import javax.validation.constraints.NotNull;

//import org.springframework.format.annotation.DateTimeFormat;

public class ClienteFormDTO  implements Serializable{
	
private static final long serialVersionUID = 8984832253102853707L;
	
	private Integer id;
	
	@NotNull
	private String cpf;
		
	@NotNull
	private String endereco;
	
	@NotNull
	private String nome;
	
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	//private Date dataCad;
	
	@NotNull
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

	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
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

	/*public Date getDataCad() {
		return dataCad;
	}

	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}*/

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
