package com.packtpub.pfbg.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.packtpub.pfbg.model.User;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class UserController 
{
	private User loginUser;
	private User registrationUser;
	private String loginStatus;
	
	public UserController() 
	{
		this.loginUser = new User();
		this.registrationUser = new User();
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
		boolean validCredentials = "admin".equals(loginUser.getUserName()) && "admin".equals(loginUser.getPassword());
		this.loginStatus  = validCredentials? "Login Successful" : "Login failed";
		return null;
	}
	
	public String register() 
	{
		System.out.println("Register User :"+ this.registrationUser);
		String msg = "User Registered Successfully";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "registration.jsf?faces-redirect=true";	
	}
	
	public void checkUserNamesExists()
	{
		String userName = this.registrationUser.getUserName();
		if("admin".equals(userName) || "test".equals(userName))
		{
			String msg = "UserName ["+userName+"] already in use.";
			FacesContext.getCurrentInstance().addMessage("registrationForm:userName", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
	}

	public String  updateUser() 
	{
		System.out.println("Updating User Id: "+this.loginUser.getId());
		String msg = "User updated Successfully";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		return "userDetails.jsf";
	}
	
	public String  deleteUser() 
	{
		System.out.println("deleting User Id: "+this.loginUser.getId());
		String msg = "User deleted Successfully";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		return "userDetails.jsf";
	}
	
	public void checkEmailExists()
	{
		String email = this.registrationUser.getEmail();
		if("admin@gmail.com".equals(email) || "test@gmail.com".equals(email))
		{
			String msg = "Email ["+email+"] already in use.";
			FacesContext.getCurrentInstance().addMessage("registrationForm:email", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
	}
}
