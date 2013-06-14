package com.packtpub.techbuzz.converters;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.entities.Role;
import com.packtpub.techbuzz.services.BuzzService;

/**
 * @author Siva
 *
 */
@Component
public class RoleConverter implements Converter
{
	@Autowired
	private BuzzService buzzService;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
	{
		//System.out.println("getAsObject ->"+value);
		if (value==null || value.trim().equals("")) {  
            return null;  
        } else {  
            try {  
            	int id = Integer.parseInt(value);
                List<Role> roles = buzzService.findAllRoles();
				for (Role r : roles ) {  
                    if (r.getRoleId() == id) {  
                    	//System.out.println("getAsObject returning ->"+u);
                        return r;  
                    }  
                }  
  
            } catch(NumberFormatException exception) {  
            	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Role");
                throw new ConverterException(msg);  
            }  
        }  
  
        return null; 
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
	{
		//System.out.println("getAsString ->"+value);
		if (value == null || value.equals("")) {  
            return "";  
        } else {
        	//System.out.println("getAsString returning ->"+String.valueOf(((User) value).getId()));
            return String.valueOf(((Role) value).getRoleId());
        } 
	}
	
}
