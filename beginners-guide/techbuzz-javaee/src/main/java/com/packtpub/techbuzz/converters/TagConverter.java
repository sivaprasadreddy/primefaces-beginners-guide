package com.packtpub.techbuzz.converters;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.packtpub.techbuzz.cache.TagCache;
import com.packtpub.techbuzz.entities.Tag;

/**
 * @author Siva
 *
 */
@FacesConverter(value="tagConverter", forClass=Tag.class)
public class TagConverter implements Converter
{
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
	{
		System.out.println("getAsObject ------>"+value);
		if (value==null || value.trim().equals("")) {  
            return null;  
        } else {  
            try {  
            	int id = Integer.parseInt(value);
                List<Tag> tags = new ArrayList<Tag>();//TODO; TagCache.getTags();
				for (Tag t : tags ) {  
                    if (t.getId() == id) {  
                        return t;  
                    }  
                }  
  
            } catch(NumberFormatException exception) {  
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));  
            }  
        }  
  
        return null; 
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
	{
		System.out.println("getAsString value------>"+value);
		if (value == null || value.equals("")) {  
            return "";  
        } else {  
            return String.valueOf(((Tag) value).getId());
        } 
	}

}
