package br.edu.ifg.filters;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class AnimalFiltroDTO implements Serializable {

	@NotNull
	private String cliente;

	public AnimalFiltroDTO() {
		super();
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
}
