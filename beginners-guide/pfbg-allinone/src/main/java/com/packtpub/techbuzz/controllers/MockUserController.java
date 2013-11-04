package com.packtpub.techbuzz.controllers;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.packtpub.techbuzz.entities.User;


/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class MockUserController 
{
	private static final Logger logger = Logger.getLogger(MockUserController.class);
	
	private User loginUser = new User();
	private User registrationUser = new User();
	private String loginStatus;
	
	public MockUserController() 
	{
	}

	public User getLoginUser() 
	{
		return loginUser;
	}

	public void setLoginUser(User loginUser) 
	{
		this.loginUser = loginUser;
	}

	public User getRegistrationUser() 
	{
		return registrationUser;
	}

	public void setRegistrationUser(User registrationUser) 
	{
		this.registrationUser = registrationUser;
	}
	public String getLoginStatus() 
	{
		return loginStatus;
	}
	
	public void setLoginStatus(String loginStatus) 
	{
		this.loginStatus = loginStatus;
	}
	
	public String login() 
	{
		boolean validCredentials = "admin@gmail.com".equals(loginUser.getEmailId()) && "admin".equals(loginUser.getPassword());
		this.loginStatus  = validCredentials? "Login Successful" : "Login failed";
		return null;
	}
	
	public String register() 
	{
		logger.info("Registering User :"+ this.registrationUser);
		String msg = "User Registered Successfully";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		this.registrationUser = new User();
		return null;
	}
	
	public String doRegister() 
	{
		logger.info("Registering User :"+ this.registrationUser);
		String msg = "User Registered Successfully";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		this.registrationUser = new User();
		return "registrationWithVal.jsf?faces-redirect=true";	
	}
	


	public String  updateUser() 
	{
		logger.info("Updating User Id: "+this.loginUser.getId());
		String msg = "User updated Successfully";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		return "userDetails.jsf";
	}
	
	public String  deleteUser() 
	{
		logger.info("deleting User Id: "+this.loginUser.getId());
		String msg = "User deleted Successfully";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		return "userDetails.jsf";
	}
	
	public void checkEmailExists()
	{
		String email = this.registrationUser.getEmailId();
		if("admin@gmail.com".equals(email) || "test@gmail.com".equals(email))
		{
			String msg = "Email ["+email+"] already in use.";
			FacesContext.getCurrentInstance().addMessage("registrationForm:emailId", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		} else {
			String msg = "Email ["+email+"] is available.";
			FacesContext.getCurrentInstance().addMessage("registrationForm:emailId", 
					new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		}
	}
}
