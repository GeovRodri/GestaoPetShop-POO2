package br.edu.ifg.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.edu.ifg.form.OrdemServicoFormDTO;

@Component
public class OrdemServicoFormValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return OrdemServicoFormDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrdemServicoFormDTO form = (OrdemServicoFormDTO) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clienteId", "required.clienteId", "Selecione um cliente para continuar");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "animalId", "required.animalId", "Selecione um animal para continuar");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data", "required.data", "Preencha uma data");

		if (form.getServicos() == null || form.getServicos().isEmpty()) {
			errors.rejectValue("servicos", "required.servicos", "Selecione pelo menos um serviço");
		}

	}
}
