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
    	if(createdOn == null){
    		createdOn = new Date();
    	}
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
	public String getTagsAsString()
	{
		if(tags != null && !tags.isEmpty())
		{
			StringBuilder sb = new StringBuilder();
			for (Tag tag : tags)
			{
				sb = sb.append(tag.getLabel()+",");
			}
			if(sb.length() > 0)
				return sb.substring(0, sb.length()-1);
		}
		return "";
	}
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    public void addTag(Tag tag)
	{
    	getTags().add(tag);
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
	
	public Rating getUserRating(int userId){
		if(ratings != null && !ratings.isEmpty()){
			for (Rating rating : ratings)
			{
				if(rating.getUserId() == userId){
					return rating;
				}
			}
		}
		return null;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	
    
}
