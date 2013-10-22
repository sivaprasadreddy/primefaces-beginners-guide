package com.packtpub.techbuzz.entities;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author siva
 */
public class User implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String emailId;
    private String password;
    private String firstName;
	private String lastName;
	private String gender;
    private String phone;
	private Date dob = new Date();
    private boolean disabled;
    private String bio;
    
    
    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String emailId, String password, String firstName, boolean disabled)
	{
		this.id = id;
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
	}
    
    @Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(!(obj instanceof User))
			return false;
		
		return ((User)obj).getId() == this.id;
	}

	@Override
	public int hashCode() {
		return (id != null)
		        ? (this.getClass().hashCode() + id.hashCode())
		        : super.hashCode();
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
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

    public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

    
}
