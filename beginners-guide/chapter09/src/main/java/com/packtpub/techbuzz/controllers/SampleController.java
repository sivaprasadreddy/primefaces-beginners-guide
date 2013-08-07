package com.packtpub.techbuzz.controllers;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.layout.LayoutUnit;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.ResizeEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;
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
		FacesMessage message = new FacesMessage("Closed Panel Id: " + event.getComponent().getId());  
        addMessage(message);  
    }  
      
    public void handleToggle(ToggleEvent event) {  
    	FacesMessage message = new FacesMessage("Toggled Panel Id: "+ event.getComponent().getId() + " ,Status:" + event.getVisibility().name());  
        addMessage(message);  
    }  
      
    private void addMessage(FacesMessage message) {  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }
    
    public String getTab1Content(){
    	return "PrimeFaces is an open source JSF component library with 100+ Rich UI Components support. " +
    			"It has built-in Ajax support based on standard JSF 2.0 Ajax APIs.";
    }
    
    public String getTab2Content(){
    	return "Java Server Faces (JSF) is a Java specification for building component-based " +
    			"user interfaces for web applications. It was formalized as a standard through " +
    			"the Java Community Process and is part of the Java Platform, Enterprise Edition.";
    }
    
    public String getTab3Content(){
    	return "Java Platform, Enterprise Edition (Java EE) is the standard in community-driven " +
    			"enterprise software. Java EE is developed using the Java Community Process, " +
    			"with contributions from industry experts, commercial and open source organizations," +
    			" Java User Groups, and countless individuals.";
    }
    
    public void onTabChange(TabChangeEvent event) {  
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab:" + event.getTab().getId());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
  
    public void onTabClose(TabCloseEvent event) {  
        FacesMessage msg = new FacesMessage("Closed Tab: " + event.getTab().getTitle());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    public void handleLayoutClose(CloseEvent event) {  
    	String msg =  "Position: "+((LayoutUnit)event.getComponent()).getPosition();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "LayoutUnit Closed", msg);  
        FacesContext.getCurrentInstance().addMessage(null, message);
    }  
  
    public void handleLayoutToggle(ToggleEvent event) {
    	String msg =  "Position: "+((LayoutUnit)event.getComponent()).getPosition() + " , Status:" + event.getVisibility().name();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"LayoutUnit Toggled",msg);  
        FacesContext.getCurrentInstance().addMessage(null, message);
    }  
     
    public void handleLayoutResize(ResizeEvent event) {  
    	String msg =  "Position: "+((LayoutUnit)event.getComponent()).getPosition() + " , Id:" + event.getComponent().getId();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "LayoutUnit Resized", msg);  
        FacesContext.getCurrentInstance().addMessage(null, message); 
    }
  
}
