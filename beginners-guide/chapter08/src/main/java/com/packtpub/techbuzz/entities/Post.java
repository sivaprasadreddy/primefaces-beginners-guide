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
    private Date createdOn = new Date();
    private List<Tag> tags;
    private List<Vote> votes;
    private User postedBy;
    private List<Comment> comments;

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

    public List<Tag> getTags() {
    	if(tags == null){
    		tags = new ArrayList<Tag>();
    	}
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Vote> getVotes() {
    	if(votes == null){
    		votes = new ArrayList<Vote>();
    	}
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
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

    public int getUpVotesCount()
    {
    	int count = 0;
    	if(getVotes()!=null){
    		for (Vote vote : votes) 
    		{
				if(vote.getVoteType()=='U'){
					count++;
				}
			}
    	}
    	return count;
    }
    
    public int getDownVotesCount()
    {
    	int count = 0;
    	if(getVotes()!=null){
    		for (Vote vote : votes) 
    		{
				if(vote.getVoteType()=='D'){
					count++;
				}
			}
    	}
    	return count;
    }
    
    public List<User> getUpVoters()
    {
    	List<User> users = new ArrayList<User>();
    	
    	if(getVotes()!=null){
    		for (Vote vote : votes) 
    		{
				if(vote.getVoteType()=='U'){
					users.add(vote.getUser());
				}
			}
    	}
    	return users;
    }
    
    public List<User> getDownVoters()
    {
    	List<User> users = new ArrayList<User>();
    	
    	if(getVotes()!=null){
    		for (Vote vote : votes) 
    		{
				if(vote.getVoteType()=='D'){
					users.add(vote.getUser());
				}
			}
    	}
    	return users;
    }
    
}
