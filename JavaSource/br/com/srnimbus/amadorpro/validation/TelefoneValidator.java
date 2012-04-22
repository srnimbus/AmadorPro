package br.com.srnimbus.amadorpro.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="srnimbus.TelefoneValidator") 
public class TelefoneValidator extends Object implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object pvalue) throws ValidatorException {

		String value = (String)pvalue;
		String DDD = "^[0-9]{2}";
		String prefixo = "( |-)?[0-9]{4,5}";
		String numero = "( |-)?[0-9]{4}$";
		Pattern mask = Pattern
				.compile(DDD + prefixo + numero);

		Matcher matcher = mask.matcher(value);

		if (!matcher.find()) {
			FacesMessage message = new FacesMessage();
			message.setDetail("Telefone inválido! O telefone deve ser fornecido com dois dígitos para o DDD, seguido dos 4 ou 5 dígitos para o código da área e de 4 digitos para o número!");
			message.setSummary("Telefone inválido! ");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}

}
