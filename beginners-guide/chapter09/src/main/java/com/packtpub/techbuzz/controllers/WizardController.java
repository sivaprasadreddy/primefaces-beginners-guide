package com.packtpub.techbuzz.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.FlowEvent;

import com.packtpub.techbuzz.entities.User;

/**
 * @author K. Siva Prasad Reddy
 * Date : 24-Jul-2013
 */

@ManagedBean
@ViewScoped
public class WizardController implements Serializable
{
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(WizardController.class.getName());  

	private boolean skip;  
	private User user = new User();

	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	 
    public boolean isSkip() {  
        return skip;  
    }  
  
    public void setSkip(boolean skip) {  
        this.skip = skip;  
    }  
      
    public String onFlowProcess(FlowEvent event) {  
    	String currentStep = event.getOldStep();
		String nextStep = event.getNewStep();
        logger.debug("Current Step:" + currentStep);  
        logger.debug("Next Step:" + nextStep);  
          
        if(skip) {  
            skip = false;   //reset in case user goes back  
            return "confirm";  
        }  
        else {  
            return event.getNewStep();  
        }  
    }
    public void save() {  
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getFirstName());  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
}
