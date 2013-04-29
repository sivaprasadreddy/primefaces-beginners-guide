package com.packtpub.techbuzz.services;

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
	
	public User login(String userName, String password)
	{
		return userRepository.login(userName, password);
	}
	
	public User register(User user)
	{
		if(userRepository.findByUserName(user.getUserName()) != null){
			throw new RuntimeException("UserName ["+user.getUserName()+"] already in use");
		}
		if(userRepository.findByEmailId(user.getEmailId()) != null){
			throw new RuntimeException("EmailId ["+user.getEmailId()+"] already in use");
		}
		return userRepository.createUser(user);
	}

	public boolean changePassword(String userName, String oldPwd, String newPwd)
	{
		int count = userRepository.changePassword(userName, oldPwd, newPwd);
		return (count > 0);
	}

}
