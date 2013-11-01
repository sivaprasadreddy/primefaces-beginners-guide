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
	private int userId;
	private int postId;

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
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}
	
}
