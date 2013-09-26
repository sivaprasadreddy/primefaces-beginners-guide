package com.packtpub.techbuzz.controllers;

import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;

@ManagedBean
@RequestScoped
public class DialogBean {

    public void viewUsers() {
        RequestContext.getCurrentInstance().openDialog("viewUsers");
    }
    
    public void viewUsersCustomized() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 320);
        
        RequestContext.getCurrentInstance().openDialog("viewUsers", options, null);
    }
    
    public void showMessage() {
        FacesMessage message = new FacesMessage("PrimeFaces 4.0 Dialog Framework");
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
}
