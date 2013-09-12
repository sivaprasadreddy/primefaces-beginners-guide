package com.packtpub.techbuzz.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private int userId;
    private Date createdOn = new Date();
    private List<Tag> tags;
    private List<Comment> comments;
    private List<Rating> ratings;
    
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

    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Tag> getTags() {
    	if(tags == null){
    		tags = new ArrayList<Tag>();
    	}
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
    	if(comments == null){
    		comments = new ArrayList<Comment>();
    	}
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

	public List<Rating> getRatings() {
		if(ratings == null){
			ratings = new ArrayList<Rating>();
		}
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
    
}
