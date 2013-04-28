/**
 * 
 */
package com.packtpub.techbuzz.repositories;

import com.packtpub.techbuzz.entities.User;


/**
 * @author siva
 *
 */
public interface UserRepository
{

	User login(String userName, String password);
	
	User findByEmailId(String email);
	
	User findByUserName(String userName);

	int changePwd(Integer userId, String oldPwd, String newPwd);

	User createUser(User user);
}
