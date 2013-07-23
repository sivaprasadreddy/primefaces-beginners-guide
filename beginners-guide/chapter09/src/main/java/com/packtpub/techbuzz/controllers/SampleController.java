package com.packtpub.techbuzz.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.ToggleEvent;

/**
 * @author K. Siva Prasad Reddy
 * Date : 23-Jul-2013
 */
@ManagedBean
@RequestScoped
public class SampleController
{
	public void handleClose(CloseEvent event) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");  
          
        addMessage(message);  
    }  
      
    public void handleToggle(ToggleEvent event) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());  
          
        addMessage(message);  
    }  
      
    private void addMessage(FacesMessage message) {  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }
}
