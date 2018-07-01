package br.edu.ifg.bean;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifg.dao.ClienteDAO;
import br.edu.ifg.dao.OrdemServicoDAO;
import br.edu.ifg.entity.Cliente;

public class OrdemServicoBean {
	
	private OrdemServicoDAO ordemServicoDAO;
	private ClienteDAO clienteDAO;
	
	private List<Cliente> clientes = new ArrayList<>();

	public OrdemServicoBean() {
		super();
		this.ordemServicoDAO = new OrdemServicoDAO();
		this.clienteDAO = new ClienteDAO();
		
		this.clientes = this.clienteDAO.getList();
	}

	public void salvar() {
		
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
