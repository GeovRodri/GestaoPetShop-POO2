package br.edu.ifg.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.edu.ifg.form.ServicoFormDTO;

@Component
public class ServicoFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ServicoFormDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipo", "required.tipo", "Preencha o tipo");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "valor", "required.valor", "Preencha o valor");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descricao", "required.descricao", "Preencha a descricao");
	}
	
}
