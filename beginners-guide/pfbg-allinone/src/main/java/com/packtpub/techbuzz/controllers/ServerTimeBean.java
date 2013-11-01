package com.packtpub.techbuzz.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class ServerTimeBean 
{
	private String time;
	public void setTime(String time) {
		this.time = time;
	}
	public String getTime() {
		return time;
	}
	public void updateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		this.time = sdf.format(new Date());
	}
	
}
