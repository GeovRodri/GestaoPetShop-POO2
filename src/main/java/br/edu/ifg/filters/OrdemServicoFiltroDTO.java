package br.edu.ifg.filters;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class OrdemServicoFiltroDTO implements Serializable {

	@NotNull
	private String animal;

	@NotNull
	private String cliente;

	public OrdemServicoFiltroDTO() {
		super();
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
}
