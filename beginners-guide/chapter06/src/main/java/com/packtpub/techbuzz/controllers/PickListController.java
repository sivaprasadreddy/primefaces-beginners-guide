package com.packtpub.techbuzz.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.entities.Role;
import com.packtpub.techbuzz.services.BuzzService;

/**
 * @author Siva
 *
 */
@Component
@Scope(value="request")
public class PickListController 
{

	@Autowired
	private BuzzService buzzService;
	
	private DualListModel<String> privileges;
	private DualListModel<Role> roles;
	
	@PostConstruct
	public void init()
	{
		//Roles
		List<Role> source = buzzService.findAllRoles();
		List<Role> target = new ArrayList<Role>();
		
		roles = new DualListModel<Role>(source, target);
		
		//Cities
		List<String> privilegesSource = new ArrayList<String>();
		List<String> privilegesTarget = new ArrayList<String>();
		
		privilegesSource.add("Create User");
		privilegesSource.add("Delete User");
		privilegesSource.add("Disable User");
		privilegesSource.add("Remove Buzz Post");
		
		privileges = new DualListModel<String>(privilegesSource, privilegesTarget);
	}
	
	public DualListModel<Role> getRoles() {
		return roles;
	}
	public void setRoles(DualListModel<Role> roles) {
		this.roles = roles;
	}
	
    public DualListModel<String> getPrivileges()
	{
		return privileges;
	}

	public void setPrivileges(DualListModel<String> privileges)
	{
		this.privileges = privileges;
	}

	public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for(Object item : event.getItems()) {
            builder.append(((Role) item).getRoleName()).append("<br />");
        }
        String msg = null;
        if(event.isAdd()){
        	msg = "Assigned Roles:<br/>"+builder.toString();
        } else {
        	msg = "Revoked Roles:<br/>"+builder.toString();
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
    }
}
                    
