package br.edu.ifg.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifg.dao.ClienteDAO;
import br.edu.ifg.dao.UsuarioDAO;
import br.edu.ifg.entity.Cliente;
import br.edu.ifg.entity.Usuario;
import br.edu.ifg.form.ClienteFormDTO;
import br.edu.ifg.validator.ClienteFormValidator;

@Controller
public class ClienteController extends Thread{
	
	@Autowired
	private ClienteDAO clienteDAO;

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	ClienteFormValidator clienteFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(clienteFormValidator);
	}
	
	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("clienteForm") @Valid ClienteFormDTO form, BindingResult result, ModelMap modelMap) {		
		Cliente cliente = new Cliente();
		return saveOrUpdate(form, result, modelMap, cliente);
	}
	
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.POST)
	public String atualizar(@ModelAttribute("clienteForm") @Valid ClienteFormDTO form, @PathVariable("id") Integer id, 
			BindingResult result, ModelMap modelMap) {
		
		Cliente cliente = this.clienteDAO.encontrar(id);
		return saveOrUpdate(form, result, modelMap, cliente);
	}
	
	@RequestMapping(value = "/cliente/{id}/delete", method = RequestMethod.GET)
	public String remover(@PathVariable("id") Integer id, ModelMap modelMap) {
		this.clienteDAO.remover(id);
		
		List<Cliente> listClientes = this.clienteDAO.getList();
		modelMap.addAttribute("listClientes", listClientes);
		modelMap.addAttribute("successMsg", "Cliente removido com sucesso!");
		return "listar-clientes";
	}
	
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
	public String updateOrdemServico(@ModelAttribute("clienteForm") ClienteFormDTO form, @PathVariable("id") Integer id, ModelMap model) { 
		Cliente cliente = this.clienteDAO.encontrar(id);
		
		if (cliente != null) {
			form.setId(cliente.getId());
			form.setNome(cliente.getNome());
			form.setCpf(cliente.getCpf());
			form.setEndereco(cliente.getEndereco());
			form.setTelefone(cliente.getTelefone());
			//form.setDataCad(cliente.getDataCad());
		}
		
		return "cliente";
	}
	
	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public String ordemServico(@ModelAttribute("clienteForm") ClienteFormDTO form, ModelMap model) { 
		return "cliente";
	}
	
	@RequestMapping(value = "/listar-clientes", method = RequestMethod.GET)
	public String listarOrdemServico(ModelMap model) { 
		List<Cliente> listClientes = this.clienteDAO.getList();
		model.addAttribute("listClientes", listClientes);
		return "listar-clientes";
	}
	
	private String saveOrUpdate(ClienteFormDTO form, BindingResult result, ModelMap modelMap, Cliente cliente) {
		if (result.hasErrors()) {
			return "cliente";
		} else {
			Usuario usuario = this.usuarioDAO.encontrar(1);
			
			// Preenchendo entidade
			cliente.setNome(form.getNome());
			cliente.setCpf(form.getCpf());
			cliente.setEndereco(form.getEndereco());
			cliente.setTelefone(form.getTelefone());
			//cliente.setDataCad(form.getDataCad());
			
			// Setando informações para log
			cliente.setDataCad(new Date());
			cliente.setUsuarioCad(usuario);
			
			if (cliente.getId() != null) {
				cliente = clienteDAO.atualizar(cliente);
			} else {
				cliente = clienteDAO.salvar(cliente);
			}
			
			List<Cliente> listClientes = this.clienteDAO.getList();
			modelMap.addAttribute("listClientes", listClientes);
			modelMap.addAttribute("successMsg", "Cliente salvo com sucesso!");
			return "listar-clientes";
		}
	}
	
	@RequestMapping(value = "/listar-clientes", method = RequestMethod.GET)
	public String criarCSV(@PathVariable("id") Integer id, ModelMap modelMap){ 
		List<Cliente> listClientes = this.clienteDAO.getList();
		modelMap.addAttribute("successMsg", "Gerando arquivo csv");
		
		Thread csv = new Thread();
		generateCsvFile("E://test.csv", listClientes);
		
		return "listar-clientes";
	}
	
	
}
