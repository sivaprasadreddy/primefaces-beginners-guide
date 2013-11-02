/**
 * 
 */
package com.packtpub.techbuzz.services;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.packtpub.techbuzz.config.AppConfig;
import com.packtpub.techbuzz.entities.User;

/**
 * @author skatam
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class UserServiceTest 
{
	@Autowired
	private UserService userService;
	
	@Test
	public void testLogin()
	{
		User user = userService.login("admin@gmail.com", "admin");
		assertNotNull(user);
		user = userService.login("blah", "blah");
		assertNull(user);
		user = userService.login("test", "test");
		assertNull(user);
		
	}
}
