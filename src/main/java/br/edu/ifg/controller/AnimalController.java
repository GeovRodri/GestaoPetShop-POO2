package br.edu.ifg.controller;

import java.util.List;
import javax.validation.Valid;
import br.edu.ifg.dao.ClienteDAO;
import br.edu.ifg.entity.Cliente;
import br.edu.ifg.filters.AnimalFiltroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import br.edu.ifg.dao.AnimalDAO;
import br.edu.ifg.entity.Animal;
import br.edu.ifg.form.AnimalFormDTO;
import br.edu.ifg.validator.AnimalFormValidator;

@Controller
public class AnimalController {

	@Autowired
	private AnimalDAO animalDAO;

	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	AnimalFormValidator animalFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		if (binder.getTarget() != null && AnimalFormDTO.class.equals(binder.getTarget().getClass())) {
			binder.setValidator(animalFormValidator);
		}
	}

	@RequestMapping(value = "/animal", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("animalForm") @Valid AnimalFormDTO form, BindingResult result, ModelMap modelMap) {
		Animal animal = new Animal();
		return saveOrUpdate(form, result, modelMap, animal);
	}

	@RequestMapping(value = "/filtrar-clientes", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<List<Cliente>> filtrarClientes(@Valid AnimalFiltroDTO filtro) {
		List<Cliente> clientes = this.clienteDAO.buscarPorNome(filtro.getCliente());
		return new ResponseEntity<>(clientes, HttpStatus.OK);
	}

	@RequestMapping(value = "/animal/{id}", method = RequestMethod.POST)
	public String atualizar(@ModelAttribute("animalForm") @Valid AnimalFormDTO form, @PathVariable("id") Integer id,
			BindingResult result, ModelMap modelMap) {

		Animal animal = this.animalDAO.encontrar(id);
		return saveOrUpdate(form, result, modelMap, animal);
	}

	@RequestMapping(value = "/animal/{id}/delete", method = RequestMethod.GET)
	public String remover(@PathVariable("id") Integer id, ModelMap modelMap) {
		this.animalDAO.remover(id);
		
		List<Animal> listAnimais = this.animalDAO.getList();
		modelMap.addAttribute("listAnimais", listAnimais);
		modelMap.addAttribute("successMsg", "Animal removido com sucesso!");
		return "listar-animais";
	}
	
	@RequestMapping(value = "/animal/{id}", method = RequestMethod.GET)
	public String updateOrdemServico(@ModelAttribute("animalForm") AnimalFormDTO form, @PathVariable("id") Integer id, ModelMap model) { 
		Animal animal = this.animalDAO.encontrar(id);
		
		if (animal != null) {
			form.setId(animal.getId());
			form.setNome(animal.getNome());
			form.setRaca(animal.getRaca());
			form.setEspecie(animal.getEspecie());
			form.setCliente(animal.getCliente().getNome());
		}
		
		return "animal";
	}
	
	@RequestMapping(value = "/animal", method = RequestMethod.GET)
	public String ordemServico(@ModelAttribute("animalForm") AnimalFormDTO form, ModelMap model) { 
		return "animal";
	}

	@RequestMapping(value = "/listar-animais", method = RequestMethod.GET)
	public String listarOrdemServico(ModelMap model) { 
		List<Animal> listAnimais = this.animalDAO.getList();
		model.addAttribute("listAnimais", listAnimais);
		return "listar-animais";
	}
	
	private String saveOrUpdate(AnimalFormDTO form, BindingResult result, ModelMap modelMap, Animal animal) {
		if (result.hasErrors()) {
			return "animal";
		} else {
			Cliente cliente = this.clienteDAO.buscarPorNome(form.getCliente()).get(0);
			
			// Preenchendo entidade
			animal.setNome(form.getNome());
			animal.setRaca(form.getRaca());
			animal.setEspecie(form.getEspecie());
			animal.setCliente(cliente);
			
			if (animal.getId() != null) {
				animal = animalDAO.atualizar(animal);
			} else {
				animal = animalDAO.salvar(animal);
			}
			
			List<Animal> listAnimais = this.animalDAO.getList();
			modelMap.addAttribute("listAnimais", listAnimais);
			modelMap.addAttribute("successMsg", "Animal salvo com sucesso!");
			return "listar-animais";
		}
	}
}