package com.packtpub.techbuzz.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;
import org.primefaces.event.ToggleEvent;

/**
 * @author K. Siva Prasad Reddy
 * Date : 23-Jul-2013
 */
@ManagedBean
@RequestScoped
public class TabController
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
    
    void sleep(long millis){
    	try
		{
			Thread.sleep(millis);
		} catch (InterruptedException e)
		{
			//e.printStackTrace();
		}
    }
    
    public String getTab1Content(){
    	//sleep(2000); // to simulate delay in dynamic loading
    	return "PrimeFaces is an open source JSF component library with 100+ Rich UI Components support. " +
    			"It has built-in Ajax support based on standard JSF 2.0 Ajax APIs.";
    }
    
    public String getTab2Content(){
    	//sleep(2000); // to simulate delay in dynamic loading
    	return "Java Server Faces (JSF) is a Java specification for building component-based " +
    			"user interfaces for web applications. It was formalized as a standard through " +
    			"the Java Community Process and is part of the Java Platform, Enterprise Edition.";
    }
    
    public String getTab3Content(){
    	//sleep(2000); // to simulate delay in dynamic loading
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
    
}
