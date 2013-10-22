package com.packtpub.techbuzz.validation;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.validate.ClientValidator;

/**
 * @author K. Siva Prasad Reddy
 * Date : 05-Oct-2013
 */
@FacesValidator("creditCardValidator")
public class CreditCardValidator implements Validator, ClientValidator
{

	private Pattern pattern;
	 
	private static final String CC_PATTERN = "^\\d{4} \\d{4} \\d{4} \\d{4}$";
 
	public CreditCardValidator() {
		pattern = Pattern.compile(CC_PATTERN);
	}

    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value == null) {
            return;
        }
        
        if(!pattern.matcher(value.toString().trim()).matches()) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Validation Error", 
                        value + " is not a valid creditcard number"));
        }
    }

    public Map<String, Object> getMetadata() {
    	Map<String, Object> metadata = new HashMap<String, Object>();
    	metadata.put("data-error-msg", "Invalid CreditCard Number");
        return metadata;
    }

    public String getValidatorId() {
        return "creditCardValidator";
    }

}
