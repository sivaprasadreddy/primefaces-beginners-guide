package com.packtpub.techbuzz.controlers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.packtpub.techbuzz.entities.User;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class BlockUIController
{
	private User registerUser = new User();
	public User getRegisterUser()
	{
		return registerUser;
	}
	public void setRegisterUser(User registerUser)
	{
		this.registerUser = registerUser;
	}

	public void doRegister() 
	{
		//To simulate 5 seconds delay from server
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Register User :"+registerUser);
		if(registerUser != null)
		{
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "User Registered successfully", null));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration failed. Please try again", null));
		}
	}
}
