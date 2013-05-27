/**
 * 
 */
package com.packtpub.techbuzz.repositories;

import java.util.List;

import com.packtpub.techbuzz.entities.User;


/**
 * @author siva
 *
 */
public interface UserRepository
{

	User login(String emailId, String password);
	
	User findByEmailId(String email);
	
	User createUser(User user);

	int changePassword(String emailId, String oldPwd, String newPwd);

	User update(User user);

	List<User> findAllUsers();
}
