package br.edu.ifg.validator;

import br.edu.ifg.dao.ClienteDAO;
import br.edu.ifg.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.edu.ifg.form.AnimalFormDTO;

import java.util.List;

@Component
public class AnimalFormValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AnimalFormDTO.class.equals(clazz);
	}

	@Autowired
	private ClienteDAO clienteDAO;

	@Override
	public void validate(Object target, Errors errors) {
		AnimalFormDTO form = (AnimalFormDTO) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required.nome", "Preencha o nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "especie", "required.especie", "Preencha uma espécie");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "raca", "required.raca", "Preencha uma raça");

		List<Cliente> clientes = this.clienteDAO.buscarPorNome(form.getCliente());

		if (clientes == null || clientes.isEmpty()) {
			errors.rejectValue("cliente", "required.cliente", "Selecione um cliente valido");
		}
	}
}
