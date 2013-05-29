package com.packtpub.techbuzz.converters;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.repositories.TagRepository;

/**
 * @author Siva
 *
 */
@Component
public class TagConverter implements Converter
{
	@Autowired
	private TagRepository tagRepository;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
	{
		if (value==null || value.trim().equals("")) {  
            return null;  
        } else {  
            try {  
            	int id = Integer.parseInt(value);
                List<Tag> tags = tagRepository.findAllTags();
				for (Tag t : tags ) {  
                    if (t.getId() == id) {  
                        return t;  
                    }  
                }  
            } catch(NumberFormatException exception) {
            	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Tag");
                throw new ConverterException(msg);  
            }  
        }  
  
        return null; 
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
	{
		if (value == null || value.equals("")) {  
            return "";  
        } else {  
            return String.valueOf(((Tag) value).getId());
        } 
	}

}
