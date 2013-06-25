package com.packtpub.techbuzz.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RateEvent;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class RatingController {

	private Integer rating1;  
    private Integer rating2;  
    private Integer rating3;  
    private Integer rating4 = 3;  
      
    public Integer getRating1() {  
        return rating1;  
    }  
  
    public void setRating1(Integer rating1) {  
        this.rating1 = rating1;  
    }  
  
    public Integer getRating2() {  
        return rating2;  
    }  
  
    public void setRating2(Integer rating2) {  
        this.rating2 = rating2;  
    }  
  
    public Integer getRating3() {  
        return rating3;  
    }  
  
    public void setRating3(Integer rating3) {  
        this.rating3 = rating3;  
    }  
  
    public Integer getRating4() {  
        return rating4;  
    }  
  
    public void setRating4(Integer rating4) {  
        this.rating4 = rating4;  
    }  
    
    public void handleRate(RateEvent rateEvent) {  
    	int rate = ((Integer) rateEvent.getRating()).intValue();  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You rated:" +rate));  
    }  
      
    public void handleCancel() {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Rating Cancelled"));  
    }
}
