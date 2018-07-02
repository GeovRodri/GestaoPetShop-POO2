package br.edu.ifg.bean.ordemservico;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifg.dao.AnimalDAO;
import br.edu.ifg.dao.ClienteDAO;
import br.edu.ifg.dao.OrdemServicoDAO;
import br.edu.ifg.dao.ServicoDAO;
import br.edu.ifg.entity.Animal;
import br.edu.ifg.entity.Cliente;
import br.edu.ifg.entity.ItemOrdemServico;
import br.edu.ifg.entity.Servico;

public class OrdemServicoBean {
	
	private OrdemServicoDAO ordemServicoDAO;
	private ClienteDAO clienteDAO;
	private AnimalDAO animalDAO;
	private ServicoDAO servicoDAO;
	
	private List<Cliente> clientes = new ArrayList<>();
	private List<Animal> animais = new ArrayList<>();
	private List<ItemOrdemServico> itensOrdemDeServico = new ArrayList<>();
	private List<Servico> servicos = new ArrayList<>();
	
	public OrdemServicoBean() {
		super();
		this.ordemServicoDAO = new OrdemServicoDAO();
		this.clienteDAO = new ClienteDAO();
		this.animalDAO = new AnimalDAO();
		this.servicoDAO = new ServicoDAO();
		
		this.clientes = this.clienteDAO.getList();
		this.animais = this.animalDAO.getList();
		this.servicos = this.servicoDAO.getList();
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

	public List<ItemOrdemServico> getItensOrdemDeServico() {
		return itensOrdemDeServico;
	}

	public void setItensOrdemDeServico(List<ItemOrdemServico> itensOrdemDeServico) {
		this.itensOrdemDeServico = itensOrdemDeServico;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
}
