/**
 * 
 */
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
	
	public UserController() {
		this.loginUser = new User();
		this.registrationUser = new User();
	}

	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}

	public User getRegistrationUser() {
		return registrationUser;
	}

	public void setRegistrationUser(User registrationUser) {
		this.registrationUser = registrationUser;
	}
	public String getLoginStatus() {
		return loginStatus;
	}
	
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	
	public String login() {
		boolean validCredentials = "admin".equals(loginUser.getUserName()) && "admin".equals(loginUser.getPassword());
		this.loginStatus  = validCredentials? "Login Successful" : "Login failed";
		return null;
	}
	
	/*
	public String login() {
		boolean validCredentials = false;
		//boolean validCredentials = "admin".equals(loginUser.getUserName()) && "admin".equals(loginUser.getPassword());
		List<User> allUsers = UserRepository.findAllUsers();
		for (User user : allUsers) {
			if(user.getUserName().equals(loginUser.getUserName()) && user.getPassword().equals(loginUser.getPassword())){
				validCredentials = true;
				break;
			}
		}
		if(validCredentials){
			return "home.jsf?faces-redirect=true";
		} else {
			JSFUtils.addErrorMsg("Invalid Credentials. Please try again.");
			return "login.jsf";
		}
		
	}
	
	*/
	
	public String register() 
	{
		System.out.println("Register User :"+ this.registrationUser);
		String msg = "User Registered Successfully";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "registration.jsf?faces-redirect=true";	
	}
	/*
	public String register() 
	{
		boolean success = true;
		System.err.println("Register User :"+ this.registrationUser);
		String userName = this.registrationUser.getUserName();
		if(isUserNamesExists(userName)){
			JSFUtils.addErrorMsg("registrationForm:userName","UserName ["+userName+"] already in use.");
			success = false;
		}
		
		if(success){
			JSFUtils.addInfoMsg("User Registered Successfully");
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			return "login.jsf?faces-redirect=true";
		} else {
			JSFUtils.addErrorMsg("User Registration Failed. Please try again.");
			return "registration.jsf";
		}		
	}
	*/
	
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

	/*public void checkUserNamesExists(){
		String userName = this.registrationUser.getUserName();
		if(isUserNamesExists(userName)){
				JSFUtils.addErrorMsg("registrationForm:userName","UserName ["+userName+"] already in use.");
		}
	}
	*/
	
	/*public boolean isUserNamesExists(){
		System.out.println("--------isUserNamesExists-------");
		String userName = this.registrationUser.getUserName();
		System.out.println(userName);
		boolean userNamesExists = isUserNamesExists(userName);
		System.out.println("userNamesExists:"+userNamesExists);
		if(userNamesExists){
			System.err.println("errr");
			JSFUtils.addErrorMsg("registrationForm:userName","UserName ["+userName+"] already in use.");
		}
		return userNamesExists;
	}*/
	
/*	public boolean isUserNamesExists(String userName){
		if(userName == null || userName.trim().length()==0){
			return false;
		}
		List<User> allUsers = UserRepository.findAllUsers();
		for (User user : allUsers) {
			if(user.getUserName().equals(userName)){
				return true;
			}
		}
		return false;
	}*/
	
	public String  updateUser() {
		System.out.println("Updating User Id: "+this.loginUser.getId());
		String msg = "User updated Successfully";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		return "userDetails.jsf";
	}
	
	public String  deleteUser() {
		System.out.println("deleting User Id: "+this.loginUser.getId());
		String msg = "User deleted Successfully";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		return "userDetails.jsf";
	}
	
	public void checkEmailExists(){
		String email = this.registrationUser.getEmail();
		if("admin@gmail.com".equals(email) || "test@gmail.com".equals(email))
		{
			String msg = "Email ["+email+"] already in use.";
			FacesContext.getCurrentInstance().addMessage("registrationForm:email", 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
	}
}
