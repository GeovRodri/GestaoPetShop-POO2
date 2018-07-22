package br.edu.ifg.csv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.ModelMap;

import br.edu.ifg.controller.OrdemServicoController;
import br.edu.ifg.dao.OrdemServicoDAO;
import br.edu.ifg.entity.OrdemServico;


public class testeCSV extends OrdemServicoController{
	
	OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO();
	
	public static void main(String[] args) {
		testeCSV teste = new testeCSV();
		ModelMap model = new ModelMap();
		List<OrdemServico> listOS = new ArrayList<>();
		
		listOS.addAll(teste.listarCSV_teste(model));
		
	
		
	}
	
	public List<OrdemServico> listarCSV_teste(ModelMap model) { 
		List<OrdemServico> listOrdemServico = this.ordemServicoDAO.getList();
		model.addAttribute("listOrdemServico", listOrdemServico);
		model.addAttribute("successMsg", "Gerando relatório .CSV");
		return listOrdemServico;
	}
	
	

}
