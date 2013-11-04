/**
 * 
 */
package com.packtpub.techbuzz.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.services.UserService;
import com.packtpub.techbuzz.utils.JSFUtils;
import com.packtpub.techbuzz.web.view.ChangePassword;

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
	
	private User loginUser;
	private User registerUser;
	private boolean userLoggedin;
	private ChangePassword changePwd = new ChangePassword();
	private String searchEmail;	
	private User searchUser = new User();
	private List<User> searchUsers = new ArrayList<User>();
	
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
			loginUser = user;
			setUserLoggedin(true);
			return "home.jsf?faces-redirect=true";
		}
		JSFUtils.addErrorMsg("Invalid EmailId and Password");
		return null;
	}
	
	public String doRegister() 
	{
		try
		{
			userService.register(registerUser);
			JSFUtils.addInfoMsg("User Registered successfully");
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			registerUser = new User();
			return "login.jsf?faces-redirect=true";
		} catch (Exception e)
		{
			JSFUtils.addErrorMsg("registrationForm",e.getMessage());
		}
		return null;
		
	}
	
	public void updateUser() 
	{
		try
		{
			loginUser = userService.updateUser(loginUser);
			JSFUtils.addInfoMsg("Updated successfully");
		} catch (Exception e)
		{
			JSFUtils.addErrorMsg("myAccountForm",e.getMessage());
		}
	}
	
	public void changePassword() 
	{
		try
		{
			boolean success = userService.changePassword(loginUser.getEmailId(), changePwd.getCurrentPwd(), changePwd.getNewPwd());
			if(!success){
				JSFUtils.addErrorMsg("changePwdForm","Current password is incorrect");
			}else {
				JSFUtils.addInfoMsg("changePwdForm","Updated successfully");
			}
		} catch (Exception e)
		{
			JSFUtils.addErrorMsg("changePwdForm",e.getMessage());
		}
		
	}
	/*
	public List<String> completeEmail(String query) 
	{
		List<String> emails = new ArrayList<String>();
		List<User> users = userService.findAllUsers();
		for (User user : users) {
			if(user.getEmailId().toLowerCase().startsWith(query.toLowerCase()))
			{
				emails.add(user.getEmailId());
			}
		}
		return emails;
	}
	*/
	public List<User> completeEmail(String query) 
	{
		List<User> filteredUsers = new ArrayList<User>();
		List<User> users = userService.findAllUsers();
		for (User user : users) {
			if(user.getEmailId().toLowerCase().startsWith(query.toLowerCase()))
			{
				filteredUsers.add(user);
			}
		}
		
		return filteredUsers;
	}
	
	public List<String> completeBio(String query) 
	{
		List<String> values = new ArrayList<String>();
		if("soft".equalsIgnoreCase(query)){
			values.add("Software");
			values.add("Software Engineer");
			values.add("Software Developer");
			values.add("Software Architect");
			values.add("Software Development");
			values.add("Software Solutions");
			
			values.add("Software Development Methodologies");
			values.add("Software Development Process");
			values.add("Software Development Life Cycle");
			values.add("Software Design");
			values.add("Software Design Guidelines");
			values.add("Software Design Strategies");
			values.add("Software Testing");
			values.add("Software Testing Tools");
						
			values.add("Soft skills");
		} else if("java".equalsIgnoreCase(query)){
			values.add("Java");
			values.add("Java Programming");
			values.add("Java Platform");
			values.add("JavaScript");
		} 
		return values;
	}
	/*
	public void searchUsers() 
	{
		this.searchUser = userService.findUserByEmail(searchEmail);
	}
	*/
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
	public ChangePassword getChangePwd() {
		return changePwd;
	}

	public void setChangePwd(ChangePassword changePwd) {
		this.changePwd = changePwd;
	}

	public String getSearchEmail() {
		return searchEmail;
	}

	public void setSearchEmail(String searchEmail) {
		this.searchEmail = searchEmail;
	}

	public User getSearchUser() {
		return searchUser;
	}

	public void setSearchUser(User searchUser) {
		this.searchUser = searchUser;
	}

	public List<User> getSearchUsers() {
		return searchUsers;
	}

	public void setSearchUsers(List<User> searchUsers) {
		this.searchUsers = searchUsers;
	}
	
}
