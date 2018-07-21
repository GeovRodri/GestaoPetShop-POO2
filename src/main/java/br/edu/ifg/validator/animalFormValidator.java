package br.edu.ifg.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.edu.ifg.form.AnimalFormDTO;
import br.edu.ifg.form.OrdemServicoFormDTO;

@Component
public class AnimalFormValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AnimalFormDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AnimalFormDTO form = (AnimalFormDTO) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required.id", "Selecione um id para continuar");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "especie", "required.especie", "Selecione uma espécie");

		if (form.getId() == null) {
			errors.rejectValue("id", "required.id", "Selecione pelo menos um id");
		}

	}
}
