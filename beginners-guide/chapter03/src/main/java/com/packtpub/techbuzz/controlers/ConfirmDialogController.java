package com.packtpub.techbuzz.controlers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.packtpub.techbuzz.utils.JSFUtils;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class ConfirmDialogController
{
	public void handleDelete(ActionEvent event) 
	{
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleted Successfully",null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void deleteUser() 
	{
		JSFUtils.addInfoMsg("Deleted User successfully");
	}
	
	public void deleteTag() 
	{
		JSFUtils.addInfoMsg("Deleted Tag successfully");
	}
	

}
