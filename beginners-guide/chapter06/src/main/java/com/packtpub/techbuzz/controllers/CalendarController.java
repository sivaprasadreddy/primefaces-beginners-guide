/**
 * 
 */
package com.packtpub.techbuzz.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

/**
 * @author skatam
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
	private Date date6;
	private Date date7;
	private Date date8;
	
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
	public Date getDate6() {
		return date6;
	}
	public void setDate6(Date date6) {
		this.date6 = date6;
	}
	public Date getDate7() {
		return date7;
	}
	public void setDate7(Date date7) {
		this.date7 = date7;
	}
	
	public Date getDate8() {
		return date8;
	}
	public void setDate8(Date date8) {
		this.date8 = date8;
	}
	public Date getMinDate()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, 2013);
		calendar.set(Calendar.MONTH, 6);
		calendar.set(Calendar.DATE, 5);
		return calendar.getTime();
	}
	
	public Date getMaxDate()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, 2013);
		calendar.set(Calendar.MONTH, 7);
		calendar.set(Calendar.DATE, 30);
		return calendar.getTime();
	}
	
	public TimeZone getTimeZone() {
		return TimeZone.getDefault();
	}
	
	public void handleDateSelect(SelectEvent se) {
		Date date = (Date) se.getObject();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Date Selected :"+date));
	}
}
