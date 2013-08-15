package com.packtpub.techbuzz.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.layout.LayoutUnit;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.ResizeEvent;
import org.primefaces.event.ToggleEvent;

/**
 * @author K. Siva Prasad Reddy
 * Date : 23-Jul-2013
 */
@ManagedBean
@RequestScoped
public class LayoutController
{
    public void handleLayoutClose(CloseEvent event) {  
    	String msg =  "Position: "+((LayoutUnit)event.getComponent()).getPosition();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "LayoutUnit Closed", msg);  
        FacesContext.getCurrentInstance().addMessage(null, message);
    }  
  
    public void handleLayoutToggle(ToggleEvent event) {
    	String msg =  "Position: "+((LayoutUnit)event.getComponent()).getPosition() 
    			+ " , Status:" + event.getVisibility().name();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"LayoutUnit Toggled",msg);  
        FacesContext.getCurrentInstance().addMessage(null, message);
    }  
     
    public void handleLayoutResize(ResizeEvent event) {  
    	String msg =  "Position: "+((LayoutUnit)event.getComponent()).getPosition() 
    			+ " , Id:" + event.getComponent().getId();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "LayoutUnit Resized", msg);  
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }
  
}
