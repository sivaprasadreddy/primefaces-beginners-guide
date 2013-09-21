/**
 * 
 */
package com.packtpub.techbuzz.repositories;

import java.util.List;

import com.packtpub.techbuzz.entities.Role;
import com.packtpub.techbuzz.entities.User;

/**
 * @author skatam
 *
 */
public interface RoleRepository extends GenericRepository<Integer, Role>
{

	List<Role> findUserRoles(Integer userId);

	void updateUserRoles(User user);

}
