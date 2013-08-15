package com.packtpub.techbuzz.repositories;

import java.util.List;

import com.packtpub.techbuzz.entities.Role;

/**
 * @author Siva
 *
 */
public interface RoleRepository
{
	
	List<Role> findAllRoles();
	
	Role getRole(Integer roleId);

	Role createRole(Role role);
	
}
