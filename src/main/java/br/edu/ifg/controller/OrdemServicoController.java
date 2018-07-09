package br.edu.ifg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifg.dao.AnimalDAO;
import br.edu.ifg.dao.ClienteDAO;
import br.edu.ifg.dao.OrdemServicoDAO;
import br.edu.ifg.dao.ServicoDAO;
import br.edu.ifg.entity.Animal;
import br.edu.ifg.entity.Cliente;
import br.edu.ifg.entity.OrdemServico;
import br.edu.ifg.entity.Servico;

@Controller
public class OrdemServicoController {

	@Autowired
	private OrdemServicoDAO ordemServicoDAO;

	@Autowired
	private ClienteDAO clienteDAO;

	@Autowired
	private AnimalDAO animalDAO;

	@Autowired
	private ServicoDAO servicoDAO;

	@RequestMapping(value = "/api/ordem-servico", method = RequestMethod.POST)
	public String salvar() {
		System.out.println("Executando a lógica de salvamento");
		return "ok";
	}
	
	@RequestMapping(value = "/api/ordem-servico", method = RequestMethod.PUT)
	public String atualizar() {
		System.out.println("Executando a lógica de atualizar");
		return "ok";
	}

	@RequestMapping(value = "/api/ordem-servico", method = RequestMethod.DELETE)
	public String remover() {
		System.out.println("Executando a lógica de remover");
		return "ok";
	}
	
	@RequestMapping(value = "/ordem-servico", method = RequestMethod.GET)
	public String ordemServico(ModelMap model, HttpServletRequest request) { 
		List<Cliente> clientes = this.clienteDAO.getList();
		List<Animal> animais = this.animalDAO.getList();
		List<Servico> servicos = this.servicoDAO.getList();

		model.addAttribute("clientes", clientes);
		model.addAttribute("animais", animais);
		model.addAttribute("servicos", servicos);

		return "ordem-servico";
	}

	@RequestMapping(value = "/listar-ordem-servico", method = RequestMethod.GET)
	public String listarOrdemServico(ModelMap model, HttpServletRequest request) { 
		List<OrdemServico> listOrdemServico = this.ordemServicoDAO.getList();
		model.addAttribute("listOrdemServico", listOrdemServico);
		return "listar-ordem-servico";
	}
}