/**
 * 
 */
package com.packtpub.primeuidemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packtpub.primeuidemo.entities.User;
import com.packtpub.primeuidemo.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class UserService 
{
	@Autowired private UserRepository userRepository;
	
	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}
	
}
