package com.packtpub.techbuzz.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author Siva
 *
 */
@ManagedBean
@RequestScoped
public class SpinnerController {

	private double price;
	private int discount;
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public int getDiscount()
	{
		return discount;
	}
	public void setDiscount(int discount)
	{
		this.discount = discount;
	}
	
}
