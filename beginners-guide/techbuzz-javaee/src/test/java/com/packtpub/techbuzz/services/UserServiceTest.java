/**
 * 
 */
package com.packtpub.techbuzz.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.packtpub.techbuzz.entities.User;

/**
 * @author skatam
 *
 */
public class UserServiceTest 
{
	private UserService userService;
	
	@Test
	public void testLogin()
	{
		User user = userService.login("admin", "admin");
		assertNotNull(user);
		user = userService.login("blah", "blah");
		assertNull(user);
		user = userService.login("test", "test");
		assertNull(user);
		
	}
}
