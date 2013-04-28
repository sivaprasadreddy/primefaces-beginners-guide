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
	
	public User register(User newUser)
	{
		return userRepository.createUser(newUser);
	}

}
