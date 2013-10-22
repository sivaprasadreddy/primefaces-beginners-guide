
package com.packtpub.techbuzz.controllers;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.services.UserService;
import com.packtpub.techbuzz.utils.JSFUtils;
import com.packtpub.techbuzz.web.view.UserBean;

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
	private UserService userService;
	
	private User loginUser = null;
	private User registerUser = new User();
	
	private UserBean userBean = new UserBean();
	
	public User getLoginUser() 
	{
		if(loginUser != null){
			return loginUser;
		}
		loginUser = JSFUtils.getLoggedinUser();
		if(loginUser == null){
			loginUser = new User();
		}
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
	
	public boolean isUserLoggedin() {
		return JSFUtils.getLoggedinUser() != null;
	}

	public UserBean getUserBean()
	{
		return userBean;
	}

	public void setUserBean(UserBean userBean)
	{
		this.userBean = userBean;
	}

	public String doLogin() 
	{
		User user = userService.login(loginUser.getEmailId(), loginUser.getPassword());
		if(user != null)
		{
			JSFUtils.setLoggedinUser(user);
			return "home.jsf?faces-redirect=true";
		}
		JSFUtils.addErrorMsg("Invalid EmailId and Password");
		return null;
	}
	
	public void doRegister() 
	{
		try
		{
			//userService.register(registerUser);
			JSFUtils.addInfoMsg("User Registered successfully");
			registerUser = new User();
		} catch (Exception e)
		{
			JSFUtils.addErrorMsg("registrationForm",e.getMessage());
		}
		
	}
	
	
}
