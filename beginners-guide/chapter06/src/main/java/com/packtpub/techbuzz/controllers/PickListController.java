/**
 * 
 */
package com.packtpub.techbuzz.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import com.packtpub.techbuzz.entities.Role;

/**
 * @author skatam
 *
 */
@ManagedBean
@RequestScoped
public class PickListController 
{

	private DualListModel<Role> roles;
	
	private DualListModel<String> cities;

	public PickListController() {
		//Roles
		List<Role> source = new ArrayList<Role>();
		List<Role> target = new ArrayList<Role>();
		
		source.add(new Role(1, "Administrator"));
		source.add(new Role(2, "Super Admin"));
		source.add(new Role(3, "HR Executive"));
		source.add(new Role(4, "Finance Dept Mngr"));
		
		roles = new DualListModel<Role>(source, target);
		
		//Cities
		List<String> citiesSource = new ArrayList<String>();
		List<String> citiesTarget = new ArrayList<String>();
		
		citiesSource.add("Hyderabad");
		citiesSource.add("Chennai");
		citiesSource.add("Bangalore");
		citiesSource.add("Pune");
		citiesSource.add("Kolkata");
		
		cities = new DualListModel<String>(citiesSource, citiesTarget);
	}
	
	public DualListModel<Role> getRoles() {
		return roles;
	}
	public void setRoles(DualListModel<Role> roles) {
		this.roles = roles;
	}
	
	public DualListModel<String> getCities() {
		return cities;	
}
	public void setCities(DualListModel<String> cities) {
		this.cities = cities;
	}
    
    public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for(Object item : event.getItems()) {
            builder.append(((Role) item).getRoleName()).append("<br />");
        }
        
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Items Transferred");
        msg.setDetail(builder.toString());
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
                    
