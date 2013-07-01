package com.packtpub.techbuzz.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.services.UserService;

/**
 * @author K. Siva Prasad Reddy
 * Date : 27-Jun-2013
 */
//@ManagedBean
//@RequestScoped
@Component
@Scope(value="view")
public class AdminController
{
	@Autowired
	private UserService userService;
	
	private List<User> users = null;
	
	public AdminController()
	{
		/*users = new ArrayList<User>();
		
		for (int i = 1; i <= 15; i++)
		{
			users.add(new User(i,"siva"+i+"@gmail.com","siva"+i,"Siva"+i,false));
		}*/
	}
	
	@PostConstruct
	void init()
	{
		users = userService.findAllUsers();
	}
	
	public List<User> getUsers()
	{
		return users;
	}
	
	public int sortByFirstName(Object firstName1, Object firstName2)
	{
		//return -1, 0 , 1 if firstName1 is less than, equal to or greater than firstName2 respectively
		return ((String)firstName1).compareToIgnoreCase(((String)firstName2));
	}
}
