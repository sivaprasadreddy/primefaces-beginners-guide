package com.packtpub.techbuzz.web.view;


/**
 * @author K. Siva Prasad Reddy
 * Date : 16-Jul-2013
 */
public class PostNode
{
	private String title;
	private String type;
	private String createdBy;
	
	public PostNode()
	{
	}

	public PostNode(String title, String createdBy)
	{
		this.title = title;
		this.createdBy = createdBy;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

}
