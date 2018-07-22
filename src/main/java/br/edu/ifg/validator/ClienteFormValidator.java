package br.edu.ifg.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import br.edu.ifg.form.ClienteFormDTO;

@Component
public class ClienteFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) { 
		return ClienteFormDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required.nome", "Preencha um nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpf", "required.cpf", "Preencha um CPF");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endereco", "required.endereco", "Preencha um endereço");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefone", "required.telefone", "Preencha uma telefone");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataCad", "required.dataCad", "Preencha uma data");
		
	}

}
