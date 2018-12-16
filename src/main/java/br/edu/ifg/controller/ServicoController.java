package br.edu.ifg.controller;

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

import br.edu.ifg.dao.ServicoDAO;
import br.edu.ifg.entity.Servico;
import br.edu.ifg.entity.Usuario;
import br.edu.ifg.form.ServicoFormDTO;
import br.edu.ifg.validator.ServicoFormValidator;

@Controller
public class ServicoController {

	@Autowired
	private ServicoDAO servicoDAO;
	
	@Autowired
	ServicoFormValidator servicoFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(servicoFormValidator);
	}

	@RequestMapping(value = "/servico", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("servicoForm") @Valid ServicoFormDTO form, BindingResult result, ModelMap modelMap) {		
		Servico servico = new Servico();
		return saveOrUpdate(form, result, modelMap, servico);
	}
	
	@RequestMapping(value = "/servico/{id}", method = RequestMethod.POST)
	public String atualizar(@ModelAttribute("servicoForm") @Valid ServicoFormDTO form, @PathVariable("id") Integer id, 
			BindingResult result, ModelMap modelMap) {
		
		Servico servico = this.servicoDAO.encontrar(id);
		return saveOrUpdate(form, result, modelMap, servico);
	}

	@RequestMapping(value = "/servico/{id}/delete", method = RequestMethod.GET)
	public String remover(@PathVariable("id") Integer id, ModelMap modelMap) {
		this.servicoDAO.remover(id);
		
		List<Servico> listServicos = this.servicoDAO.getList();
		modelMap.addAttribute("listServicos", listServicos);
		modelMap.addAttribute("successMsg", "Servico removido com sucesso!");
		return "listar-servicos";
	}
	
	@RequestMapping(value = "/servico/{id}", method = RequestMethod.GET)
	public String updateOrdemServico(@ModelAttribute("servicoForm") ServicoFormDTO form, @PathVariable("id") Integer id, ModelMap model) { 
		Servico servico = this.servicoDAO.encontrar(id);
		
		if (servico != null) {
			form.setId(servico.getId());
			form.setTipo(servico.getTipo());
			form.setValor(servico.getValor());
			form.setDescricao(servico.getDescricao());
		}
		
		return "servico";
	}
	
	@RequestMapping(value = "/servico", method = RequestMethod.GET)
	public String ordemServico(@ModelAttribute("servicoForm") ServicoFormDTO form, ModelMap model) { 
		return "servico";
	}

	@RequestMapping(value = "/listar-servicos", method = RequestMethod.GET)
	public String listarServico(ModelMap model) { 
		List<Servico> listServicos = this.servicoDAO.getList();
		model.addAttribute("listServicos", listServicos);
		return "listar-servicos";
	}
	
	private String saveOrUpdate(ServicoFormDTO form, BindingResult result, ModelMap modelMap, Servico servico) {
		if (result.hasErrors()) {
			return "servico";
		} else {
			// Preenchendo entidade
			servico.setTipo(form.getTipo());
			servico.setValor(form.getValor());
			servico.setDescricao(form.getDescricao());
			
			if (servico.getId() != null) {
				servico = servicoDAO.atualizar(servico);
			} else {
				servico = servicoDAO.salvar(servico);
			}
			
			List<Servico> listServicos = this.servicoDAO.getList();
			modelMap.addAttribute("listServicos", listServicos);
			modelMap.addAttribute("successMsg", "Servico salvo com sucesso!");
			return "listar-servicos";
		}
	}
}