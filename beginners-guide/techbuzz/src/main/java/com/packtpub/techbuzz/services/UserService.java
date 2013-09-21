package com.packtpub.techbuzz.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packtpub.techbuzz.entities.Role;
import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.repositories.RoleRepository;
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
	@Autowired private RoleRepository roleRepository;
	
	public User login(String loginId, String password)
	{
		User user = userRepository.login(loginId, password);
		if(user != null){
			this.populateUserRoles(Arrays.asList(user));
		}
		return user;
	}
	
	public void register(User user)
	{		
		if(userRepository.findByEmailId(user.getEmailId()) != null){
			throw new RuntimeException("EmailId ["+user.getEmailId()+"] already in use");
		}
		userRepository.create(user);
		List<Role> roles = user.getRoles();
		for (Role role : roles)
		{
			roleRepository.create(role);
		}
	}

	public boolean changePassword(String loginId, String oldPwd, String newPwd)
	{
		int count = userRepository.changePassword(loginId, oldPwd, newPwd);
		return (count > 0);
	}

	public User findUserByEmail(String searchEmail) {
		User user = userRepository.findByEmailId(searchEmail);
		this.populateUserRoles(Arrays.asList(user));
		return user;
	}

	public List<User> findAllUsers() {
		List<User> users = userRepository.findAll();
		this.populateUserRoles(users);
		return users;
	}

	public User updateUser(User user) {
		userRepository.update(user);
		return user;
	}
	
	public void updateUserRoles(User user){
		roleRepository.updateUserRoles(user);
	}

	public void disableUsers(List<User> users) {
		userRepository.updateUsersStatus(users, "DISABLED");	
	}

	public void enableUsers(List<User> users) {
		userRepository.updateUsersStatus(users, "ENABLED");			
	}

	public List<Role> findAllRoles()
	{
		return roleRepository.findAll();
	}
		
	private void populateUserRoles(List<User> users)
	{
		for (User user : users)
		{
			List<Role> roles = roleRepository.findUserRoles(user.getId());
			user.setRoles(roles);
		}		
	}
}
