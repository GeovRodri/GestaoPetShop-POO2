package br.edu.ifg.form;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class AnimalFormDTO implements Serializable {
	
	private static final long serialVersionUID = 8984832253102853707L;
	
	private Integer id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String especie;
	
	@NotNull
	private String raca;

	@NotNull
	private String cliente;
		
	public AnimalFormDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
}
