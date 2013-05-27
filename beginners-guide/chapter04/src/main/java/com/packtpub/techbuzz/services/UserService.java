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
	
	public User login(String userName, String password)
	{
		return userRepository.login(userName, password);
	}
	
	public User register(User user)
	{		
		if(userRepository.findByEmailId(user.getEmailId()) != null){
			throw new RuntimeException("EmailId ["+user.getEmailId()+"] already in use");
		}
		return userRepository.createUser(user);
	}

	public boolean changePassword(String emailId, String oldPwd, String newPwd)
	{
		int count = userRepository.changePassword(emailId, oldPwd, newPwd);
		return (count > 0);
	}

	public User update(User user) {
		return userRepository.update(user);
	}

	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmailId(email);
	}

}
