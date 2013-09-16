/**
 * 
 */
package com.packtpub.techbuzz.controllers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.services.UserService;
import com.packtpub.techbuzz.utils.JSFUtils;

/**
 * @author Siva
 *
 */
@ManagedBean
@SessionScoped
public class UserController implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EJB private UserService userService;
	
	private User loginUser;
	private User registerUser;
	private boolean userLoggedin;
	
	public UserController() {
		loginUser = new User();
		registerUser = new User();
	}
	
	public String doLogin() 
	{
		User user = userService.login(loginUser.getEmailId(), loginUser.getPassword());
		if(user != null)
		{
			JSFUtils.setLoggedinUser(user);
			setUserLoggedin(true);
			return "home.jsf?faces-redirect=true";
		}
		JSFUtils.addErrorMsg("Invalid EmailId and Password");
		return null;
	}
	
	public void doRegister() 
	{
		try
		{
			userService.createUser(registerUser);
			JSFUtils.addInfoMsg("User Registered successfully");
			registerUser = new User();
		} catch (Exception e)
		{
			JSFUtils.addErrorMsg("registrationForm",e.getMessage());
		}
		
	}
	
	public String logout()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.invalidate();
		return "login.jsf?faces-redirect=true";
	}
	public Map<String, Boolean> getHasMessages() {
	    HashMap<String, Boolean> flags = new HashMap<String, Boolean>(1);
	    Iterator<String> messages = FacesContext.getCurrentInstance().getClientIdsWithMessages();
	    while (messages.hasNext()) {
	        flags.put(messages.next(), Boolean.TRUE);
	    }
	    return flags;
	}
	
	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}

	public User getRegisterUser() {
		return registerUser;
	}

	public void setRegisterUser(User registerUser) {
		this.registerUser = registerUser;
	}
	public boolean isUserLoggedin()
	{
		return userLoggedin;
	}
	public void setUserLoggedin(boolean userLoggedin)
	{
		this.userLoggedin = userLoggedin;
	}
	
}
