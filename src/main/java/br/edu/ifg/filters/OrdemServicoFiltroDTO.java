package br.edu.ifg.filters;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class OrdemServicoFiltroDTO implements Serializable {

	@NotNull
	private String animal;

	public OrdemServicoFiltroDTO() {
		super();
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}
}
