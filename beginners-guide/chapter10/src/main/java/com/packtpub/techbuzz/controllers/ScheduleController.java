package com.packtpub.techbuzz.controllers;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 * @author K. Siva Prasad Reddy
 * Date : 18-Jul-2013
 */
@ManagedBean
@ViewScoped
public class ScheduleController implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private ScheduleModel eventModel;
	public ScheduleController() 
	{
		eventModel = new DefaultScheduleModel();
		
		//eventModel.addEvent(new DefaultScheduleEvent("John BirthDay", buildDate(2013,6,18,9,10), buildDate(2013,6,18,9,40)));
		//eventModel.addEvent(new DefaultScheduleEvent("Meeting with ABC Corp", buildDate(2013,6,19,12,0), buildDate(2013,6,19,13,0)));
		//eventModel.addEvent(new DefaultScheduleEvent("Product XYZ Release Plan Meeting", buildDate(2013,10,16,8,0), buildDate(2013,10,16,9,0)));
		
		eventModel.addEvent(new DefaultScheduleEvent("John BirthDay", today(9,10), today(9,40)));
		eventModel.addEvent(new DefaultScheduleEvent("Meeting with ABC Corp", tomorrow(12,0), tomorrow(13,0)));
		eventModel.addEvent(new DefaultScheduleEvent("Product XYZ Release Plan Meeting", today(18,0), today(19,30)));
		
	}

	public static Date today(int hour, int minute)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
		calendar.set(Calendar.HOUR, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	public static Date tomorrow(int hour, int minute)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE)+1, 0, 0, 0);
		calendar.set(Calendar.HOUR, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	public static Date buildDate(int year, int month, int day, int hour, int minute)
	{
		Calendar t = Calendar.getInstance();
		t.set(year, month, day);
		t.set(Calendar.HOUR, hour);
		t.set(Calendar.MINUTE, minute);
		t.set(Calendar.SECOND, 0);
		return t.getTime();
	}
	public ScheduleModel getEventModel()
	{
		return eventModel;
	}
	
	public void onEventSelect(SelectEvent selectEvent) {
		ScheduleEvent event = (ScheduleEvent) selectEvent.getObject();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selected Event :"+event.getTitle()));
	}
	
	public void onDateSelect(SelectEvent selectEvent) {
		Date date = (Date) selectEvent.getObject();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Schedule Event at:"+date));
	}
	
	public void onEventMove(ScheduleEntryMoveEvent event) {
		String msg = "Event moved. Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}
	
	public void onEventResize(ScheduleEntryResizeEvent event) {
		String msg = "Event resized. Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}	
}

class MyLazyScheduleModel extends LazyScheduleModel
{
	private static final long serialVersionUID = 1L;

	@Override
	public void loadEvents(Date start, Date end) 
	{
		clear();
		//fetch events between start and end times
		addEvent(new DefaultScheduleEvent("Meeting with ABC Corp", ScheduleController.tomorrow(12,0), ScheduleController.tomorrow(13,0)));
		addEvent(new DefaultScheduleEvent("Product XYZ Release Plan Meeting", ScheduleController.today(18,0), ScheduleController.today(19,30)));
		
	}	
}