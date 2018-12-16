package br.edu.ifg.form;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class OrdemServicoFormDTO implements Serializable {
	
	private static final long serialVersionUID = 8984832253102853707L;
	
	private Integer id;
	
	@NotNull
	private String cliente;
	
	@NotNull
	private String animal;
	
	@NotNull
	private Integer clienteId;
	
	@NotNull
	private Integer animalId;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data;
	
	@NotNull
	@NotEmpty
	private List<Integer> servicos;
	
    
    private boolean recurringService;

    
	public boolean getRecurringService() {
		return recurringService;
	}

	public void setRecurringService(boolean recurringService) {
		this.recurringService = recurringService;
	}
	
	public OrdemServicoFormDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}
	
	public Integer getAnimalId() {
		return animalId;
	}

	public void setAnimalId(Integer animalId) {
		this.animalId = animalId;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Integer> getServicos() {
		return servicos;
	}

	public void setServicos(List<Integer> servicos) {
		this.servicos = servicos;
	}

	public String getCliente() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getAnimal() {
		// TODO Auto-generated method stub
		return null;
	}
}
