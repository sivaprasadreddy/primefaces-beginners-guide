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
public interface UserRepository extends GenericRepository<Integer, User>
{

	User login(String loginId, String password);
	
	User findByEmailId(String email);
	
	User findByUserName(String userName);

	int changePassword(String loginId, String oldPwd, String newPwd);

	void updateUsersStatus(List<User> users, String status);

}
