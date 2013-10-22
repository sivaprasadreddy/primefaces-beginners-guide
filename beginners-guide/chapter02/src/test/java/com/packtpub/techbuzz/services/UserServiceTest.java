package com.packtpub.techbuzz.services;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.packtpub.techbuzz.config.AppConfig;
import com.packtpub.techbuzz.entities.User;

/**
 * @author Siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class UserServiceTest 
{
	@Autowired
	private UserService userService;
	
	@Test
	public void login()
	{
		System.out.println(userService);
		User user = userService.login("invalid", "invalid");
		Assert.assertNull(user);
		
		user = userService.login("admin@gmail.com", "admin");
		Assert.assertNotNull(user);
		
	}
	
	@Test
	public void register()
	{
		User user = new User();
		user.setEmailId("foo@gmail.com");
		user.setPassword("bar");
		user.setFirstName("Mr");
		user.setLastName("Foo");
		user.setPhone("922221222545");
		user.setDob(new Date());
		user.setDisabled(false);
		
		User createdUser = userService.register(user);
		Assert.assertNotNull(createdUser);
		
	}
	
	@Test
	public void changePassword()
	{
		boolean success = userService.changePassword("test@gmail.com","test","testtest");
		Assert.assertTrue(success);
	}
}
