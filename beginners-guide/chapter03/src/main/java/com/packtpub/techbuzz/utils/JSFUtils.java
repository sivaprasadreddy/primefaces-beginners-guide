/**
 * 
 */
package com.packtpub.techbuzz.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * @author Siva
 *
 */
public final class JSFUtils {
	
	public static void addInfoMsg(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public static void addErrorMsg(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	}
	
	public static void addInfoMsg(String component, String msg) {
		FacesContext.getCurrentInstance().addMessage(component, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	}
	
	public static void addErrorMsg(String component, String msg) {
		FacesContext.getCurrentInstance().addMessage(component, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	}
}
