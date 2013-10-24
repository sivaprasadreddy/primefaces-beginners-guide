package com.packtpub.techbuzz.controlers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.packtpub.techbuzz.utils.JSFUtils;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class FragmentController
{
	
	private String emailId;
	private String firstName;
	private String lastName;
	private String phone;
	private String fax;
	private String password;
	private String confPassword;
	
	public void updateUserDetails()
	{
		JSFUtils.addInfoMsg("User details updated successfully");
	}
	public void updateContactDetails()
	{
		JSFUtils.addInfoMsg("Contact details updated successfully");
	}
	public void updatePassword()
	{
		JSFUtils.addInfoMsg("Password updated successfully");
	}
	
	public String getEmailId()
	{
		return emailId;
	}
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getFax()
	{
		return fax;
	}
	public void setFax(String fax)
	{
		this.fax = fax;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getConfPassword()
	{
		return confPassword;
	}
	public void setConfPassword(String confPassword)
	{
		this.confPassword = confPassword;
	}
	
}
