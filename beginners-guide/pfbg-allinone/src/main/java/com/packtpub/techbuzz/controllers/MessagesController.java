package com.packtpub.techbuzz.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.utils.EmailValidator;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class MessagesController
{
	private User user = new User();
	public void setUser(User user)
	{
		this.user = user;
	}
	public User getUser()
	{
		return user;
	}
	
	public void doRegister(ActionEvent event)
	{
		boolean valid = EmailValidator.validate(user.getEmailId());
		if(!valid)
		{
			FacesContext.getCurrentInstance().addMessage("userRegForm:emailId", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email is invalid", null));
		}
		
		if(user.getPassword().length() < 4){
			FacesContext.getCurrentInstance().addMessage("userRegForm:password",
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password length is too short", null));
		}
		
		if(user.getFirstName().length() > 12){
			FacesContext.getCurrentInstance().addMessage("userRegForm:firstName", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "FirstName length is too long", null));
		} else if(user.getFirstName().length() > 8){
			FacesContext.getCurrentInstance().addMessage("userRegForm:firstName",
					new FacesMessage(FacesMessage.SEVERITY_WARN, "FirstName length is long", null));
		} else if(user.getFirstName().length() < 4){
			FacesContext.getCurrentInstance().addMessage("userRegForm:firstName",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "FirstName length is too short", null));
		}
		
	}
	
	
	public void addHtmlMessages()
	{
		FacesContext.getCurrentInstance().addMessage("form1:fName",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "<font size='4'>FirstName : "+user.getFirstName()+"</font>", null));
		FacesContext.getCurrentInstance().addMessage("form1:lName",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "<font size='4'>LastName :"+user.getLastName()+"</font>", null));
	}
	
	public void handleForm2()
	{
		FacesContext.getCurrentInstance().addMessage("form2:ufName",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "FirstName : "+user.getFirstName(), null));
		FacesContext.getCurrentInstance().addMessage("form2:ulName",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "LastName :"+user.getLastName(), null));
	}
	
	public void addInfoMsg()
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("PrimeFaces Rocks!"));
	}
	
	public void addMultipleMsgs()
	{
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Sample Info Msg", null));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Sample Warn Msg", null));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Sample Error Msg", null));
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Sample Fatal Msg", null));
		
	}
}
