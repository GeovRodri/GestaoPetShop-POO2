package br.edu.ifg.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifg.dao.AnimalDAO;
import br.edu.ifg.dao.UsuarioDAO;
import br.edu.ifg.entity.Animal;
import br.edu.ifg.entity.Usuario;
import br.edu.ifg.form.AnimalFormDTO;

@Controller
public class AnimalController {

	@Autowired
	private AnimalDAO animalDAO;

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	// TODO: Importar o validator que vc criou
	
	@Autowired
	AnimalFormValidator animalFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// TODO: Criar o validator e descomentar o código depois
		binder.setValidator(animalFormValidator);
	}

	@RequestMapping(value = "/animal", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("animalForm") @Valid AnimalFormDTO form, BindingResult result, Model model, ModelMap modelMap) {		
		if (result.hasErrors()) {
			return "animal";
		} else {
			Usuario usuario = this.usuarioDAO.encontrar(1);
			
			Animal animal = new Animal();
			// preencher cadastro do animal com os campos do formulario
			
			animal.setDataCad(new Date());
			animal.setUsuarioCad(usuario);
			
			animal = animalDAO.salvar(animal);
			
			List<Animal> listAnimal = this.animalDAO.getList();
			modelMap.addAttribute("listAnimal", listAnimal);
			modelMap.addAttribute("successMsg", "Animal inserido com sucesso!");
			return "listar-animal";
		}
	}
	
	@RequestMapping(value = "/animal", method = RequestMethod.PUT)
	public String atualizar() {
		// TODO: Criar metodo de atualizar o animal
		System.out.println("Executando a lógica de atualizar");
		return "ok";
	}

	@RequestMapping(value = "/animal", method = RequestMethod.DELETE)
	public String remover() {
		// TODO: criar metodo de remover o animal
		System.out.println("Executando a lógica de remover");
		return "ok";
	}
	
	@RequestMapping(value = "/animal", method = RequestMethod.GET)
	public String animal(@ModelAttribute("animalForm") AnimalFormDTO form, ModelMap model, HttpServletRequest request) { 
		List<Animal> animais = this.animalDAO.getList();
		model.addAttribute("animais", animais);
		
		return "animal";
	}

	@RequestMapping(value = "/listar-animal", method = RequestMethod.GET)
	public String listarAnimal(ModelMap model, HttpServletRequest request) { 
		List<Animal> listAnimal = this.animalDAO.getList();
		model.addAttribute("listAnimal", listAnimal);
		return "listar-animal";
	}
}