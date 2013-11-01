package com.packtpub.techbuzz.validation;

import java.util.Map;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.primefaces.convert.ClientConverter;

/**
 * @author K. Siva Prasad Reddy
 * Date : 05-Oct-2013
 */
@FacesConverter("creditCardConverter")
public class CreditCardConverter implements Converter, ClientConverter
{
	private static final String CC_PATTERN = "^\\d{4} \\d{4} \\d{4} \\d{4}$";
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
	{
		if (value==null || value.trim().equals("")) {  
            return null;  
        } else {  
        	if(!Pattern.compile(CC_PATTERN).matcher(value).matches()){
        		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, 
        				"Conversion Error", "Can't convert "+value+" into CreditCard Number");
                throw new ConverterException(msg);  
        	}            	
            return new CreditCardBean(value);
        }  
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
	{
		if (value == null || value.equals("")) {  
            return "";  
        } else if(value instanceof CreditCardBean){  
            return String.valueOf(((CreditCardBean) value).toString());
        } 
		return "";
	}

	@Override
	public Map<String, Object> getMetadata()
	{
		return null;
	}

	@Override
	public String getConverterId()
	{
		return "creditCardConverter";
	}
}
