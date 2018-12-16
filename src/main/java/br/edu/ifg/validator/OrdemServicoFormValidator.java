package br.edu.ifg.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.edu.ifg.dao.AnimalDAO;
import br.edu.ifg.dao.ClienteDAO;
import br.edu.ifg.entity.Animal;
import br.edu.ifg.entity.Cliente;
import br.edu.ifg.form.OrdemServicoFormDTO;

@Component
public class OrdemServicoFormValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return OrdemServicoFormDTO.class.equals(clazz);
	}
	
	@Autowired
	private AnimalDAO animalDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;

	@Override
	public void validate(Object target, Errors errors) {
		OrdemServicoFormDTO form = (OrdemServicoFormDTO) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clienteId", "required.clienteId", "Selecione um cliente para continuar");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "animalId", "required.animalId", "Selecione um animal para continuar");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data", "required.data", "Preencha uma data");
		
		List<Cliente> clientes = this.clienteDAO.buscarPorNome(form.getCliente());
		List<Animal> animais   = this.animalDAO.buscarPorNome(form.getAnimal()); 
		
		
		
		if (clientes == null || clientes.isEmpty()) {
			errors.rejectValue("cliente", "required.cliente", "Selecione um cliente valido");
		}
		
		if (animais == null  || animais.isEmpty()){
			errors.rejectValue("animal", "required.animal", "Selecione um animal valido");
		}
		
		if (form.getServicos() == null || form.getServicos().isEmpty()) {
			errors.rejectValue("servicos", "required.servicos", "Selecione pelo menos um serviço");
		}
	}
}
