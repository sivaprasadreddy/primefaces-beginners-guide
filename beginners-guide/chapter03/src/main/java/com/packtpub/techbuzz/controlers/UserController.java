/**
 * 
 */
package com.packtpub.techbuzz.controlers;

import javax.annotation.PostConstruct;

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
//@ManagedBean
//@RequestScoped
@Component
@Scope("request")
public class UserController 
{
	
	@Autowired
	private UserService userService;
	
	private User loginUser;
	private User registerUser;
	
	public UserController() {
		loginUser = new User();
		registerUser = new User();
	}
	
	@PostConstruct
	public void init() {
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
		
	public String doLogin() 
	{
		User user = userService.login(loginUser.getUserName(), loginUser.getPassword());
		if(user != null)
		{
			return "home.jsf?faces-redirect=true";
		}
		JSFUtils.addErrorMsg("Invalid UserName and Password. Please try again");
		return null;
	}
	
	public String doRegister() 
	{
		User user = userService.register(registerUser);
		if(user != null)
		{
			JSFUtils.addInfoMsg("User Registered successfully");
		} else {
			JSFUtils.addErrorMsg("Registration failed. Please try again");
		}
		return null;
	}
}
