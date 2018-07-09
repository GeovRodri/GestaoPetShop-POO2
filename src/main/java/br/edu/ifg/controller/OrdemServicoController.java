package br.edu.ifg.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifg.dao.AnimalDAO;
import br.edu.ifg.dao.ClienteDAO;
import br.edu.ifg.dao.OrdemServicoDAO;
import br.edu.ifg.dao.ServicoDAO;
import br.edu.ifg.dao.UsuarioDAO;
import br.edu.ifg.entity.Animal;
import br.edu.ifg.entity.Cliente;
import br.edu.ifg.entity.OrdemServico;
import br.edu.ifg.entity.Servico;
import br.edu.ifg.entity.Usuario;
import br.edu.ifg.exception.ValidacaoException;
import br.edu.ifg.form.OrdemServicoFormularioDTO;

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
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@RequestMapping(value = "/api/ordem-servico", method = RequestMethod.POST)
	public String salvar(OrdemServicoFormularioDTO form, HttpSession session, ModelMap model) {
		System.out.println("Executando a lógica de salvamento");
		
		if (form.getClienteId() == null || form.getAnimalId() == null || form.getData() == null) {
			throw new ValidacaoException("Preencha os campos obrigatórios!");
		}		
		
		Cliente cliente = this.clienteDAO.encontrar(form.getClienteId());
		Animal animal = this.animalDAO.encontrar(form.getAnimalId());
		Usuario usuario = this.usuarioDAO.encontrar(1);
		
		OrdemServico ordemServico = new OrdemServico();
		ordemServico.setCliente(cliente);
		ordemServico.setAnimal(animal);
		ordemServico.setDataServico(form.getData());
		
		ordemServico.setDataCad(new Date());
		ordemServico.setUsuarioCad(usuario);
		
		ordemServico = ordemServicoDAO.salvar(ordemServico);
		
		model.addAttribute("successMsg", "Ordem de serviço salva com sucesso!");
		return "listar-ordem-servico";
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