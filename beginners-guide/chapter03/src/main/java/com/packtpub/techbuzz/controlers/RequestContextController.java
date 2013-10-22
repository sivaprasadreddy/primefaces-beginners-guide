package com.packtpub.techbuzz.controlers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;

import com.packtpub.techbuzz.entities.User;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class RequestContextController
{
	private String emailId = "";
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}
	public String getEmailId()
	{
		return emailId;
	}
	
	public void doSearch()
	{
		RequestContext context = RequestContext.getCurrentInstance();
		context.update("form1");
		
		context.addCallbackParam("emailId", emailId);
		User user = new User();
		user.setFirstName("Optimus");
		user.setLastName("Prime");
		context.addCallbackParam("user", user);
		
		context.execute("dlg.show()");
		
	}
	
	public void scroll()
	{
		RequestContext.getCurrentInstance().scrollTo("panel");
	}
}
