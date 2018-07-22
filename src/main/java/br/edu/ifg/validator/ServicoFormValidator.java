package br.edu.ifg.validator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.edu.ifg.form.ClienteFormDTO;
import br.edu.ifg.form.ServicoFormDTO;

@Controller
public class ServicoFormValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) { 
		return ServicoFormDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tipo", "required.tipo", "Preencha um tipo");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "valor", "required.valor", "Preencha um valor");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descricao", "required.descricao", "Preencha um descricao");
		
		
	}

}


