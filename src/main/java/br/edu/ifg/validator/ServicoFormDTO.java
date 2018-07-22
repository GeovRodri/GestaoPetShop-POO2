package br.edu.ifg.form;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

public class ServicoFormDTO implements Serializable {
	
	private static final long serialVersionUID = 8984832253102853707L;
	
	private Integer id;
	
	@NotNull
	private String tipo;
	
	@NotNull
	private Float valor;
	
	@NotNull
	private String descricao;
		
	public ServicoFormDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
