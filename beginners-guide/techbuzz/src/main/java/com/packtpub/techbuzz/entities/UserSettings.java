package com.packtpub.techbuzz.entities;

import java.io.Serializable;

/**
 * @author K. Siva Prasad Reddy
 * Date : 23-Sep-2013
 */
public class UserSettings implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int userId;
	private String theme = "aristo";
	private boolean receiveEmailFeed;
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getTheme()
	{
		return theme;
	}
	public void setTheme(String theme)
	{
		this.theme = theme;
	}
	public boolean isReceiveEmailFeed()
	{
		return receiveEmailFeed;
	}
	public void setReceiveEmailFeed(boolean receiveEmailFeed)
	{
		this.receiveEmailFeed = receiveEmailFeed;
	}
	
}
