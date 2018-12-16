package br.edu.ifg.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import br.edu.ifg.dao.AnimalDAO;
import br.edu.ifg.dao.ClienteDAO;
import br.edu.ifg.dao.OrdemServicoDAO;
import br.edu.ifg.dao.ServicoDAO;
import br.edu.ifg.dao.UsuarioDAO;
import br.edu.ifg.entity.Animal;
import br.edu.ifg.entity.Cliente;
import br.edu.ifg.entity.ItemOrdemServico;
import br.edu.ifg.entity.OrdemServico;
import br.edu.ifg.entity.Servico;
import br.edu.ifg.entity.Usuario;
import br.edu.ifg.filters.AnimalFiltroDTO;
import br.edu.ifg.filters.OrdemServicoFiltroDTO;
import br.edu.ifg.form.OrdemServicoFormDTO;
import br.edu.ifg.thread.GenerateCsvFile;
import br.edu.ifg.validator.OrdemServicoFormValidator;

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
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	OrdemServicoFormValidator ordemServicoFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(ordemServicoFormValidator);
	}

	@RequestMapping(value = "/ordem-servico", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("ordemServicoForm") @Valid OrdemServicoFormDTO form, BindingResult result, ModelMap modelMap) {		
		OrdemServico ordemServico = new OrdemServico();
		return saveOrUpdate(form, result, modelMap, ordemServico);
	}
	
	@RequestMapping(value = "/filtrar-clientes-no-Ordem-Servico", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<Cliente>> filtrarClientes(@Valid AnimalFiltroDTO filtro) {
		List<Cliente> clientes = this.clienteDAO.buscarPorNome(filtro.getCliente());
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/filtrar-animais-no-Ordem-Servico", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<Animal>> filtrarAnimais(@Valid OrdemServicoFiltroDTO filtro) {
		List<Animal> animais = this.animalDAO.buscarPorNome(filtro.getAnimal());
		return new ResponseEntity<>(animais, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/ordem-servico/{id}", method = RequestMethod.POST)
	public String atualizar(@ModelAttribute("ordemServicoForm") @Valid OrdemServicoFormDTO form, @PathVariable("id") Integer id, 
			BindingResult result, ModelMap modelMap) {
		
		OrdemServico ordemServico = this.ordemServicoDAO.encontrar(id);
		return saveOrUpdate(form, result, modelMap, ordemServico);
	}

	@RequestMapping(value = "/ordem-servico/{id}/delete", method = RequestMethod.GET)
	public String remover(@PathVariable("id") Integer id, ModelMap modelMap) {
		this.ordemServicoDAO.remover(id);
		
		List<OrdemServico> listOrdemServico = this.ordemServicoDAO.getList();
		modelMap.addAttribute("listOrdemServico", listOrdemServico);
		modelMap.addAttribute("successMsg", "Ordem de serviço removida com sucesso!");
		return "listar-ordem-servico";
	}
	
	@RequestMapping(value = "/ordem-servico/{id}", method = RequestMethod.GET)
	public String updateOrdemServico(@ModelAttribute("ordemServicoForm") OrdemServicoFormDTO form, 
			@PathVariable("id") Integer id, ModelMap model) { 
		populateDefaultModel(model);
		OrdemServico ordemServico = this.ordemServicoDAO.encontrar(id);
		
		if (ordemServico != null) {
			form.setId(ordemServico.getId());
			form.setClienteId(ordemServico.getAnimal().getCliente().getId());
			form.setAnimalId(ordemServico.getAnimal().getId());
			form.setData(ordemServico.getDataServico());
			form.setRecurringService(ordemServico.getRecurringService());
			
			List<Integer> servicos = new ArrayList<>();
			
			if (ordemServico.getItens() != null && !ordemServico.getItens().isEmpty()) {
				ordemServico.getItens().forEach((item) -> {
					servicos.add(item.getServico().getId());
				});
			}
			
			form.setServicos(servicos);
		}
		
		return "ordem-servico";
	}
	
	@RequestMapping(value = "/ordem-servico", method = RequestMethod.GET)
	public String ordemServico(@ModelAttribute("ordemServicoForm") OrdemServicoFormDTO form, ModelMap model) { 
		populateDefaultModel(model);
		return "ordem-servico";
	}

	@RequestMapping(value = "/buscar-animais-cliente/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Animal>> buscarAnimais(@PathVariable("id") Integer id) {
		Cliente cliente = this.clienteDAO.encontrar(id);
		List<Animal> animais = new ArrayList<>();

		if (cliente != null && !cliente.getAnimais().isEmpty()) {
			animais = cliente.getAnimais();
		}

		return new ResponseEntity<>(animais, HttpStatus.OK);
	}

	@RequestMapping(value = "/listar-ordem-servico", method = RequestMethod.GET)
	public String listarOrdemServico(ModelMap model) { 
		List<OrdemServico> listOrdemServico = this.ordemServicoDAO.getList();
		model.addAttribute("listOrdemServico", listOrdemServico);
		return "listar-ordem-servico";
	}
	
	@RequestMapping(value = "/listar-ordem-servico/gerar", method = RequestMethod.GET)
	public String listarCSV(ModelMap model) { 
		
		// Inicializando thread para a geração dos csv
		GenerateCsvFile thread = new GenerateCsvFile();
		applicationContext.getAutowireCapableBeanFactory().autowireBean(thread); // adicionando ao contexto do spring
		thread.start();
		
		// Retornando para a tela com a mensagem de geração do csv
		List<OrdemServico> listOrdemServico = this.ordemServicoDAO.getList();
		model.addAttribute("listOrdemServico", listOrdemServico);
		model.addAttribute("successMsg", "Gerando relatório CSV");
		return "listar-ordem-servico";
	}
	
	private String saveOrUpdate(OrdemServicoFormDTO form, BindingResult result, ModelMap modelMap, OrdemServico ordemServico) {
		if (result.hasErrors()) {
			populateDefaultModel(modelMap);
			return "ordem-servico";
		} else {
			ordemServico.getItens().clear();
			Usuario usuario = this.usuarioDAO.encontrar(1);
			Cliente cliente = this.clienteDAO.buscarPorNome(form.getCliente()).get(0);
			Animal animal = this.animalDAO.buscarPorNome(form.getCliente()).get(0);
			
			ordemServico.setAnimal(animal);
			ordemServico.setDataServico(form.getData());
			
			ordemServico.setDataCad(new Date());
			ordemServico.setUsuarioCad(usuario);
			ordemServico.setRecurringService(form.getRecurringService());
			
			if (form.getServicos() != null && !form.getServicos().isEmpty()) {
				for (Integer servicoId : form.getServicos()) {
					ItemOrdemServico item = new ItemOrdemServico();
					
					Servico servico = this.servicoDAO.encontrar(servicoId);
					item.setServico(servico);
					
					item.setOrdemServico(ordemServico);	
					item.setDataCad(new Date());
					item.setUsuarioCad(usuario); 
					
					ordemServico.getItens().add(item);
				}
			}
			
			if (ordemServico.getId() != null) {
				ordemServico = ordemServicoDAO.atualizar(ordemServico);
			} else {
				ordemServico = ordemServicoDAO.salvar(ordemServico);
			}
			
			List<OrdemServico> listOrdemServico = this.ordemServicoDAO.getList();
			modelMap.addAttribute("listOrdemServico", listOrdemServico);
			modelMap.addAttribute("successMsg", "Ordem de serviço salva com sucesso!");
			return "listar-ordem-servico";
		}
	}
	
	private void populateDefaultModel(ModelMap model) {
		List<Cliente> clientes = this.clienteDAO.getList();
		List<Animal> animais = this.animalDAO.getList();
		List<Servico> servicos = this.servicoDAO.getList();

		model.addAttribute("clientes", clientes);
		model.addAttribute("animais", animais);
		model.addAttribute("listServicos", servicos);
	}
		
}