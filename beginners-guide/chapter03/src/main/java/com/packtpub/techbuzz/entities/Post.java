package com.packtpub.techbuzz.entities;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author siva
 */
public class Post implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String title;
    private String description;
    private Date createdOn = new Date();
    private User postedBy;

    public Post() {
    }

    public Post(Integer id) {
        this.id = id;
    }

    public Post(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public Post(Integer id, String title, String description, Date createdOn) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdOn = createdOn;
    }
    public Post(Integer id, String title, Date createdOn) {
        this.id = id;
        this.title = title;
        this.createdOn = createdOn;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
   
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

}
