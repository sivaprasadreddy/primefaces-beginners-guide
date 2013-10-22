
package com.packtpub.techbuzz.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
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
@Scope(value="request")
public class UserController implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;
	
	private User loginUser = null;
	private User registerUser = new User();
	private ChangePassword changePwd = new ChangePassword();
	private String searchEmail;
	
	private User searchUser = new User();
	private List<User> searchUsers = new ArrayList<User>();
	
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
			userService.register(registerUser);
			JSFUtils.addInfoMsg("User Registered successfully");
			registerUser = new User();
			RequestContext.getCurrentInstance().execute("registrationDlg.hide()");
		} catch (Exception e)
		{
			JSFUtils.addErrorMsg("registrationForm",e.getMessage());
		}
		
	}
	
	public void updateUser() 
	{
		try
		{
			loginUser = userService.update(loginUser);
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
	
	public List<User> completeEmailPojo(String query) 
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
	
	public void searchUsers() 
	{
		this.searchUser = userService.findUserByEmail(searchEmail);
	}
	
	public String logout()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.invalidate();
		return "welcome.jsf?faces-redirect=true";
	}
	
	public void handleFirstNameSave(){
		System.out.println("-----------handleFirstNameSave------");
	}
	public void handleFirstNameCancel(){
		System.out.println("-----------handleFirstNameCancel------");
	}
	public void handleLastNameChanged(){
		System.out.println("-----------handleLastNameChanged------");
	}
}
