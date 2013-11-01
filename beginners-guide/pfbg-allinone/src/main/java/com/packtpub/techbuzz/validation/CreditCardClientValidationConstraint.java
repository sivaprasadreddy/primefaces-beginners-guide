
package com.packtpub.techbuzz.validation;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.validation.metadata.ConstraintDescriptor;

import org.primefaces.validate.bean.ClientValidationConstraint;

public class CreditCardClientValidationConstraint implements ClientValidationConstraint {

    public static final String MESSAGE_METADATA = "data-cc-msg";
    
    @SuppressWarnings("rawtypes")
	public Map<String, Object> getMetadata(ConstraintDescriptor constraintDescriptor) {
        Map<String,Object> metadata = new HashMap<String, Object>();
        Map attrs = constraintDescriptor.getAttributes();
        String message = (String)attrs.get("message");
        
        
        if(message.startsWith("{") && message.endsWith("}")) {
        	FacesContext context = FacesContext.getCurrentInstance();
        	Locale locale = context.getViewRoot().getLocale();
        	ResourceBundle bundle = ResourceBundle.getBundle("ValidationMessages", locale);
            //ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
            String key = message.substring(1, message.length()-1);
            String msg = bundle.getString(key);
            if(msg == null){
            	metadata.put(MESSAGE_METADATA, message);
            }else {
            	metadata.put(MESSAGE_METADATA, msg);
            }
        } 
        
        return metadata;
    }

    public String getValidatorId() {
        return CreditCard.class.getSimpleName();
    }
    
}
