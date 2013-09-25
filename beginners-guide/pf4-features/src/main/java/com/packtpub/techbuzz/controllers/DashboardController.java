package com.packtpub.techbuzz.controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

/**
 * @author K. Siva Prasad Reddy
 * Date : 24-Jul-2013
 */
@ManagedBean
@ViewScoped
public class DashboardController implements Serializable 
{  
  
	private static final long serialVersionUID = 1L;
	private DashboardModel model;  
      
    public DashboardController() 
    {  
        model = new DefaultDashboardModel();  
        DashboardColumn column1 = new DefaultDashboardColumn();  
        DashboardColumn column2 = new DefaultDashboardColumn();  
        DashboardColumn column3 = new DefaultDashboardColumn();  
        
        column1.addWidget("twitter");
		column1.addWidget("facebook");
		column1.addWidget("youtube");
		
		column2.addWidget("linkedIn");
		
		column3.addWidget("dzone");
		column3.addWidget("jcg");
  
        model.addColumn(column1);  
        model.addColumn(column2);  
        model.addColumn(column3);  
    }  
      
    public void handleReorder(DashboardReorderEvent event) {  
        FacesMessage message = new FacesMessage();  
        message.setSeverity(FacesMessage.SEVERITY_INFO);  
        message.setSummary("Reordered: " + event.getWidgetId());  
        message.setDetail("Item index: " + event.getItemIndex() 
        		+ ", Column index: " + event.getColumnIndex() 
        		+ ", Sender index: " + event.getSenderColumnIndex());  
          
        addMessage(message);  
    }  
      
      
    private void addMessage(FacesMessage message) {  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
      
    public DashboardModel getModel() {  
        return model;  
    } 

}
