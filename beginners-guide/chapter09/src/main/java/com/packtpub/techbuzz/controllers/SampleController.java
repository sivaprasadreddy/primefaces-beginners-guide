package com.packtpub.techbuzz.controllers;

import java.util.Date;

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
    
    public String getTab1Content(){
    	//System.out.println("*****Tab1 Content*******");
    	return "Tab1 Content" + new Date();
    }
    
    public String getTab2Content(){
    	//System.out.println("*****Tab2 Content*******");
    	return "Tab2 Content"+ new Date();
    }
    
    public String getTab3Content(){
    	//System.out.println("*****Tab3 Content*******");
    	return "Tab3 Content"+ new Date();
    }
    
    public void onTabChange(TabChangeEvent event) {  
        FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab:" + event.getTab().getId());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
  
    public void onTabClose(TabCloseEvent event) {  
        FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: " + event.getTab().getTitle());  
  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
    
    
}
