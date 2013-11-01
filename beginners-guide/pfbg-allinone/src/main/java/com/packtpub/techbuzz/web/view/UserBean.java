package com.packtpub.techbuzz.web.view;

import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.packtpub.techbuzz.validation.CreditCard;
import com.packtpub.techbuzz.validation.CreditCardBean;

/**
 * @author K. Siva Prasad Reddy
 * Date : 03-Oct-2013
 */
public class UserBean
{
	private Integer id;
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Invalid Email Id")
    private String emailId;
	@Size(min=2,max=5)  
    private String password;
	@Size(min=1, message="FirstName should not be empty")
    private String firstName;
	private String lastName;
	@Pattern(regexp="^\\d{3}-\\d{3}-\\d{4}$")
    private String phone;
    @Past
	private Date dob;
    @AssertTrue(message="You must agree to Terms and Conditions")
    private boolean agreeToTnc;
	
    private String cc;
    @CreditCard
    private String creditCard;
    private CreditCardBean creditCardBean;
    
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getEmailId()
	{
		return emailId;
	}
	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
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
	public boolean isAgreeToTnc()
	{
		return agreeToTnc;
	}
	public void setAgreeToTnc(boolean agreeToTnc)
	{
		this.agreeToTnc = agreeToTnc;
	}
	

    public void setCc(String cc)
	{
		this.cc = cc;
	}
    public String getCc()
	{
		return cc;
	}
    
    public String getCreditCard()
	{
		return creditCard;
	}
	public void setCreditCard(String creditCard)
	{
		this.creditCard = creditCard;
	}
	
	public CreditCardBean getCreditCardBean()
	{
		return creditCardBean;
	}
	public void setCreditCardBean(CreditCardBean creditCardBean)
	{
		this.creditCardBean = creditCardBean;
	}
}
