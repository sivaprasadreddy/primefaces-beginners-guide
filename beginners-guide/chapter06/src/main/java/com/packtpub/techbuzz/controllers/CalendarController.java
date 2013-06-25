package com.packtpub.techbuzz.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class CalendarController {

	private Date date1;
	private Date date2;
	private Date date3;
	private Date date4;
	private Date date5;
	
	
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	public Date getDate2() {
		return date2;
	}
	public void setDate2(Date date2) {
		this.date2 = date2;
	}
	public Date getDate3() {
		return date3;
	}
	public void setDate3(Date date3) {
		this.date3 = date3;
	}
	public Date getDate4() {
		return date4;
	}
	public void setDate4(Date date4) {
		this.date4 = date4;
	}
	
	public Date getDate5() {
		return date5;
	}
	public void setDate5(Date date5) {
		this.date5 = date5;
	}
	
	public Date getMinDate() throws ParseException 
	{
		return new SimpleDateFormat("dd-MM-yyyy").parse("01-06-2013");
	}
	
	public Date getMaxDate() throws ParseException
	{
		return new SimpleDateFormat("dd-MM-yyyy").parse("15-08-2013");
	}
	
	public TimeZone getTimeZone() {
		return TimeZone.getDefault();
	}
	
	public void handleDateSelect(SelectEvent se) {
		Date date = (Date) se.getObject();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Date Selected :"+date));
	}
}
