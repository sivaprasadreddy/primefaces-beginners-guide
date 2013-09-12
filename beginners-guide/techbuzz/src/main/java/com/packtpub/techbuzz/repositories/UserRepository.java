/**
 * 
 */
package com.packtpub.techbuzz.repositories;

import com.packtpub.techbuzz.entities.User;


/**
 * @author siva
 *
 */
public interface UserRepository extends GenericRepository<Integer, User>
{

	User login(String loginId, String password);
	
	User findByEmailId(String email);
	
	User findByUserName(String userName);

	User createUser(User user);

	int changePassword(String loginId, String oldPwd, String newPwd);
	

}
