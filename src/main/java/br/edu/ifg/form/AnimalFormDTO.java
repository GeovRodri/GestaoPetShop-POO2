package br.edu.ifg.form;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class AnimalFormDTO implements Serializable {
	
	private static final long serialVersionUID = 8984832253102853707L;
	
	private Integer id;
	
	// TODO: Os campos estão errados, verificar na classe Animal.java quais campos esse cadastro tem ok
	// Após verificar mapear aqui com o mesmo nome que vc colocou no path lá no JSP ok
	@NotNull
	private String nome;
	
	@NotNull
	private String especie;
	
	@NotNull
	private String raca;
	
	@NotNull
		
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

}
