
package com.packtpub.techbuzz.validation;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class CreditCardConstraintValidator implements ConstraintValidator<CreditCard, String>
{

    private Pattern pattern;
 
	private static final String CC_PATTERN = "^\\d{4} \\d{4} \\d{4} \\d{4}$";
    
    public void initialize(CreditCard a) {
        pattern = Pattern.compile(CC_PATTERN);
    }

    public boolean isValid(String value, ConstraintValidatorContext cvc) {
        if(value == null)
            return true;
        else{
        	return pattern.matcher(value.toString()).matches();
        }
    }
    
}