package com.packtpub.techbuzz.validation;

/**
 * @author K. Siva Prasad Reddy 
 * Date : 05-Oct-2013
 */
public class CreditCardBean
{
	private String number;

	public CreditCardBean(String number)
	{
		this.number = number;
	}

	public String toString()
	{
		return number;
	}
}
