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

	private Date dob1;
	private Date dob2;
	private Date dob3;
	private Date dob4;
	private Date dob5;
	
	public Date getDob1()
	{
		return dob1;
	}

	public void setDob1(Date dob1)
	{
		this.dob1 = dob1;
	}

	public Date getDob2()
	{
		return dob2;
	}

	public void setDob2(Date dob2)
	{
		this.dob2 = dob2;
	}

	public Date getDob3()
	{
		return dob3;
	}

	public void setDob3(Date dob3)
	{
		this.dob3 = dob3;
	}

	public Date getDob4()
	{
		return dob4;
	}

	public void setDob4(Date dob4)
	{
		this.dob4 = dob4;
	}

	public Date getDob5()
	{
		return dob5;
	}

	public void setDob5(Date dob5)
	{
		this.dob5 = dob5;
	}

	public Date getDobMinDate() throws ParseException 
	{
		return new SimpleDateFormat("dd-MM-yyyy").parse("01-06-2013");
	}
	
	public Date getDobMaxDate() throws ParseException
	{
		return new SimpleDateFormat("dd-MM-yyyy").parse("15-08-2013");
	}
	
	public TimeZone getTimeZone() {
		return TimeZone.getDefault();
	}
	
	public void handleDobSelect(SelectEvent se) {
		Date date = (Date) se.getObject();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Date Selected :"+date));
	}
}
