package com.packtpub.techbuzz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService
{
	
	@Autowired private UserRepository userRepository;
	
	public User login(String loginId, String password)
	{
		return userRepository.login(loginId, password);
	}
	
	public void register(User user)
	{		
		if(userRepository.findByEmailId(user.getEmailId()) != null){
			throw new RuntimeException("EmailId ["+user.getEmailId()+"] already in use");
		}
		userRepository.create(user);
	}

	public boolean changePassword(String loginId, String oldPwd, String newPwd)
	{
		int count = userRepository.changePassword(loginId, oldPwd, newPwd);
		return (count > 0);
	}

	public User findUserByEmail(String searchEmail) {
		return userRepository.findByEmailId(searchEmail);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User updateUser(User user) {
		userRepository.update(user);
		return user;
	}

	public void disableUsers(List<User> users) {
		userRepository.updateUsersStatus(users, "DISABLED");	
	}

	public void enableUsers(List<User> users) {
		userRepository.updateUsersStatus(users, "ENABLED");			
	}

}
