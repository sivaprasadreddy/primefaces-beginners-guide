/**
 * 
 */
package com.packtpub.techbuzz.controllers;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.services.UserService;
import com.packtpub.techbuzz.utils.JSFUtils;

/**
 * @author Siva
 *
 */
@Component
@Scope(value="session")
public class UserController implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Autowired
	private volatile UserService userService;
	
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
			userService.register(registerUser);
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
