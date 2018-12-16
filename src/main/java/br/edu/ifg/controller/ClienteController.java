package br.edu.ifg.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import br.edu.ifg.entity.Animal;
import br.edu.ifg.util.Utils;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import br.edu.ifg.dao.ClienteDAO;
import br.edu.ifg.entity.Cliente;
import br.edu.ifg.entity.Usuario;
import br.edu.ifg.form.ClienteFormDTO;
import br.edu.ifg.validator.ClienteFormValidator;

@Controller
public class ClienteController extends Thread{
	
	@Autowired
	private ClienteDAO clienteDAO;
	
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
			// Preenchendo entidade
			cliente.setNome(form.getNome());
			cliente.setCpf(form.getCpf());
			cliente.setEndereco(form.getEndereco());
			cliente.setTelefone(form.getTelefone());

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

	@RequestMapping(value = "/listar-clientes/gerar", method = RequestMethod.GET)
	public @ResponseBody
	void listarCSV(HttpServletResponse response) {
		List<Cliente> clientes = this.clienteDAO.getList();
		String sFileName = "listagem_de_clientes.csv";

		// Setando os headers
		response.setContentType("text/csv;charset=utf-8");
		response.setHeader("Content-Disposition","attachment; filename=\"" + sFileName + ".csv\"");
		response.setHeader("Transfer-Encoding", "Chunked");
		response.setHeader("Content-Description", "File Transfer");

		try {
			OutputStream resOs = response.getOutputStream();
			OutputStream buffOs = new BufferedOutputStream(resOs);
			OutputStreamWriter outputWriter = new OutputStreamWriter(buffOs,"UTF-8");
			CSVWriter writer = new CSVWriter(outputWriter);

			writer.writeNext("Id,Nome,CPF,Endereço,Telefone".split(","));
			for (int i = 0; i < clientes.size(); i++) {
				Cliente cliente = clientes.get(i);
				String[] item = new String[5];
				item[0] = cliente.getId().toString();
				item[1] = cliente.getNome();
				item[2] = cliente.getCpf();
				item[3] = cliente.getEndereco();
				item[4] = cliente.getTelefone();

				writer.writeNext(item);
			}

			writer.flush();
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}