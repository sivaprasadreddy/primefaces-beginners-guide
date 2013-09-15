/**
 * 
 */
package com.packtpub.techbuzz.controlers;

import org.apache.log4j.Logger;
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
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	private User loginUser = new User();
	private User registerUser = new User();
	
	public UserController() 
	{
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
		User user = userService.login(loginUser.getEmailId(), loginUser.getPassword());
		if(user != null)
		{
			return "home.jsf?faces-redirect=true";
		}
		JSFUtils.addErrorMsg("Invalid Email and Password");
		return null;
	}
	
	public String doRegister() 
	{
		try
		{
			userService.register(registerUser);
			JSFUtils.addInfoMsg("User Registered successfully");
		} catch (Exception e)
		{
			logger.error(e.getMessage(),e);
			JSFUtils.addErrorMsg("Registration failed. Cause: "+e.getMessage());
		}
		
		return null;
	}
}
