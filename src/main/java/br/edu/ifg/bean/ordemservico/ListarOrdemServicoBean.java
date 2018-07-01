package br.edu.ifg.bean.ordemservico;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifg.dao.OrdemServicoDAO;
import br.edu.ifg.entity.OrdemServico;

public class ListarOrdemServicoBean {
	
	private OrdemServicoDAO ordemServicoDAO;
	private List<OrdemServico> listOrdemServico = new ArrayList<>();

	public ListarOrdemServicoBean() {
		super();
		this.ordemServicoDAO = new OrdemServicoDAO();
		listOrdemServico = this.ordemServicoDAO.getList();
	}

	public List<OrdemServico> getListOrdemServico() {
		return listOrdemServico;
	}

	public void setListOrdemServico(List<OrdemServico> listOrdemServico) {
		this.listOrdemServico = listOrdemServico;
	}
}
