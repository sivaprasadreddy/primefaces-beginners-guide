package com.packtpub.techbuzz.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 * @author K. Siva Prasad Reddy
 * Date : 11-Jul-2013
 */
@ManagedBean
@RequestScoped
public class CarouselController
{
	private List<String> books;
	public CarouselController()
	{
		books = new ArrayList<String>();
		books.add("PFBG_Raw.jpg");
		books.add("PF_Cookbook.jpg");
		books.add("PF_Starter.jpg");
		books.add("JSF2_Cookbook.jpg");
		
	}
	
	public List<String> getBooks()
	{
		return books;
	}

}
