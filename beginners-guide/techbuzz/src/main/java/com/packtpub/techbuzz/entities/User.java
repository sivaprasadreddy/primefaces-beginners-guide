package com.packtpub.techbuzz.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author siva
 */
public class User implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String userName;
    private String emailId;
    private String password;
    private String firstName;
	private String lastName;
    private String phone;
	private Date dob = new Date();
    private boolean disabled;
    private List<Role> roles = new ArrayList<Role>();
    private List<Vote> votes = new ArrayList<Vote>();
    private List<Rating> ratings = new ArrayList<Rating>();
    private List<Post> posts = new ArrayList<Post>();
    private Set<Comment> comments = new HashSet<Comment>();

    public User() 
    {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String userName, String emailId, String password)
	{
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
	}

	public User(Integer id, String userName, String emailId, String password,
			String firstName, String lastName, String phone, Date dob,
			boolean disabled) {
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.dob = dob;
		this.disabled = disabled;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public Date getDob()
	{
		return dob;
	}

	public void setDob(Date dob)
	{
		this.dob = dob;
	}

	public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }
    
    public List<Rating> getRatings()
	{
		return ratings;
	}

	public void setRatings(List<Rating> ratings)
	{
		this.ratings = ratings;
	}

	public List<Post> getPosts()
	{
		return posts;
	}

	public void setPosts(List<Post> posts)
	{
		this.posts = posts;
	}

	public List<Post> getLinks() {
        return posts;
    }

    public void setLinks(List<Post> posts) {
        this.posts = posts;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
    
}
