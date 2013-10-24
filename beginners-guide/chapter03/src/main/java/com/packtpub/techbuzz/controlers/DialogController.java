package com.packtpub.techbuzz.controlers;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.SelectEvent;

import com.packtpub.techbuzz.entities.User;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class DialogController
{
	private static final Logger logger = Logger.getLogger(DialogController.class);
	
	private User registerUser = new User();

	private User selectedUser = null;
	
	public User getRegisterUser()
	{
		return registerUser;
	}
	public void setRegisterUser(User registerUser)
	{
		this.registerUser = registerUser;
	}
	
	public void handleDialogClose(CloseEvent event) {  
		String msg = event.getComponent().getId() + " dialog is closed";
        FacesContext facesContext = FacesContext.getCurrentInstance();  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);  
        facesContext.addMessage("SampleDialog", message);  
    }
	
	public void doRegister() 
	{
		boolean registered = false;
		try {
			logger.info("Register User "+registerUser);
			String msg = "User Registered successfully";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
			registerUser = new User();
			registered = true;
			//RequestContext.getCurrentInstance().execute("registrationDlg.hide();");
			//RequestContext.getCurrentInstance().execute("$('#registerLink').fadeOut();");
		} catch (Exception e) {
			String msg = e.getMessage();
			String componentId = "registrationFormDlg";
			FacesContext.getCurrentInstance().addMessage(componentId, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
		RequestContext.getCurrentInstance().addCallbackParam("registered", registered);
	}

	public void showUserSearchForm()
	{
		Map<String,Object> options = new HashMap<String, Object>();  
        options.put("modal", true);  
        options.put("draggable", false);  
        options.put("resizable", false);  
        options.put("contentHeight", 400);  
          
        RequestContext.getCurrentInstance().openDialog("searchUsers", options, null);
	}
	
	public void handleSelectUser(SelectEvent event)
	{  
        User user = (User) event.getObject();  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "User Selected", "User:" + user.getEmailId());  
        FacesContext.getCurrentInstance().addMessage(null, message); 
        this.setSelectedUser(user);
    }  
	
	public void selectUserFromDialog(User user)
	{
		RequestContext.getCurrentInstance().closeDialog(user);
	}
	
	public void showFacesMessage()
	{
		RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage("PrimeFaces 4.0" , "PrimeFaces rocks!!!"));
	}
	public User getSelectedUser()
	{
		return selectedUser;
	}
	public void setSelectedUser(User selectedUser)
	{
		this.selectedUser = selectedUser;
	}
}
