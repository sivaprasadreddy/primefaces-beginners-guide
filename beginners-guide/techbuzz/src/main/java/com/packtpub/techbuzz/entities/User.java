package com.packtpub.techbuzz.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private String bio;
    private boolean disabled;
    private UserSettings userSettings;
    private List<Role> roles = new ArrayList<Role>();

    public User() 
    {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String emailId, String password)
	{
		this.id = id;
		this.emailId = emailId;
		this.password = password;
	}

	public User(Integer id, String emailId, String password,
			String firstName, String lastName, String phone, Date dob,
			boolean disabled) {
		this.id = id;
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.dob = dob;
		this.disabled = disabled;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

    public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public UserSettings getUserSettings()
	{
    	if(userSettings == null){
    		userSettings = new UserSettings();
    	}
		return userSettings;
	}

	public void setUserSettings(UserSettings userSettings)
	{
		this.userSettings = userSettings;
	}

	public List<Role> getRoles() {
    	if(roles == null){
    		roles = new ArrayList<Role>();
    	}
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
