/**
 * 
 */
package com.packtpub.techbuzz.repositories;

import java.util.List;

import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.entities.UserSettings;


/**
 * @author siva
 *
 */
public interface UserRepository extends GenericRepository<Integer, User>
{

	User login(String loginId, String password);
	
	User findByEmailId(String email);
	
	int changePassword(String loginId, String oldPwd, String newPwd);

	void updateUsersStatus(List<User> users, String status);
	
	void insertUserSettings(UserSettings settings);
	
	UserSettings getUserSettings(int userId);

	void updateUserSettings(UserSettings settings);

}
