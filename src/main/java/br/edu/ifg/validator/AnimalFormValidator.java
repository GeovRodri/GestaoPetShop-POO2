package br.edu.ifg.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.edu.ifg.form.AnimalFormDTO;

@Component
public class AnimalFormValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AnimalFormDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required.nome", "Preencha o nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "especie", "required.especie", "Preencha uma espécie");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "raca", "required.raca", "Preencha uma raça");
	}
}
