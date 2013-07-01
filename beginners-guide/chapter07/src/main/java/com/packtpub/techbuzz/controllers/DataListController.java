package com.packtpub.techbuzz.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.packtpub.techbuzz.entities.User;

/**
 * @author K. Siva Prasad Reddy
 * Date : 27-Jun-2013
 */
@ManagedBean
@RequestScoped
public class DataListController
{
	private List<User> users = null;
	private List<User> allUsers = null;
	
	public DataListController()
	{
		users = new ArrayList<User>();
		allUsers = new ArrayList<User>();
		
		for (int i = 1; i <= 3; i++)
		{
			users.add(new User(i,"siva"+i+"@gmail.com","siva"+i,"Siva"+i,false));
		}
		
		for (int i = 1; i <= 15; i++)
		{
			allUsers.add(new User(i,"siva"+i+"@gmail.com","siva"+i,"Siva"+i,false));
		}
		
	}
	public List<User> getUsers()
	{
		return users;
	}
	public List<User> getAllUsers()
	{
		return allUsers;
	}
}
