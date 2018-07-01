package br.edu.ifg.bean.ordemservico;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifg.dao.AnimalDAO;
import br.edu.ifg.dao.ClienteDAO;
import br.edu.ifg.dao.OrdemServicoDAO;
import br.edu.ifg.entity.Animal;
import br.edu.ifg.entity.Cliente;

public class OrdemServicoBean {
	
	private OrdemServicoDAO ordemServicoDAO;
	private ClienteDAO clienteDAO;
	private AnimalDAO animalDAO;
	
	private List<Cliente> clientes = new ArrayList<>();
	private List<Animal> animais = new ArrayList<>();

	public OrdemServicoBean() {
		super();
		this.ordemServicoDAO = new OrdemServicoDAO();
		this.clienteDAO = new ClienteDAO();
		this.animalDAO = new AnimalDAO();
		
		this.clientes = this.clienteDAO.getList();
		this.animais = this.animalDAO.getList();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
}
