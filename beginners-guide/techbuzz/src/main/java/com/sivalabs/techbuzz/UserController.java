/**
 * 
 */
package com.sivalabs.techbuzz;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class UserController 
{
	
	private User loginUser;
	private User registerUser;
	private List<User> userList;
	
	public UserController() {
		loginUser = new User();
		registerUser = new User();
	}
	
	@PostConstruct
	public void init() {
		this.userList = new ArrayList<User>();
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
	
	public List<User> getUserList() {
		return userList;
	}
	
	public String doLogin() 
	{
		User user = this.login(loginUser.getUserName(), loginUser.getPassword());
		if(user != null)
		{
			return "home.jsf?faces-redirect=true";
		}
		JSFUtils.addErrorMsg("Invalid UserName and Password. Please try again");
		return null;
	}
	
	private User login(String userName, String password)
	{
		if("sivalabs".equals(userName) && "sivalabs".equals(password)){
			User user = new User();
			user.setId(1);
			user.setUserName("sivalabs");
			user.setFirstName("Siva Prasad Reddy");
			user.setEmail("sivaprasadreddy.k@gmail.com");
			return user;
		}
		return null;
	}

	public String doRegister() 
	{
		
		return "";
	}
}
