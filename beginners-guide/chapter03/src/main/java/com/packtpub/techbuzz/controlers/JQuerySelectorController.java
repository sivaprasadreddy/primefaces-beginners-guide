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
public class JQuerySelectorController
{
	private User user = new User();
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}

	public void doLogin() 
	{
		if("admin@gmail.com".equals(user.getEmailId()) && "admin".equals(user.getPassword()))
		{
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Login successful", null));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed", null));
		}
	}
}
