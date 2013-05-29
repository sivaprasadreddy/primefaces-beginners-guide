package com.packtpub.techbuzz.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author siva
 */
public class Comment implements Serializable
{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String message;
	private Date createdOn;
	private User postedBy;
	private Post post;

	public Comment()
	{
	}

	public Comment(Integer id)
	{
		this.id = id;
	}

	public Comment(Integer id, String message, Date createdOn)
	{
		this.id = id;
		this.message = message;
		this.createdOn = createdOn;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public Date getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	public User getPostedBy()
	{
		return postedBy;
	}

	public void setPostedBy(User postedBy)
	{
		this.postedBy = postedBy;
	}

	public Post getPost()
	{
		return post;
	}

	public void setPost(Post post)
	{
		this.post = post;
	}

}
