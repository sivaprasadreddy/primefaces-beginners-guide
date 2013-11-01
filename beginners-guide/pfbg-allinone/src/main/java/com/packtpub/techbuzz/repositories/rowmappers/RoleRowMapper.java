/**
 * 
 */
package com.packtpub.techbuzz.repositories.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.packtpub.techbuzz.entities.Role;

/**
 * @author skatam
 *
 */
public class RoleRowMapper implements RowMapper<Role>
{
	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Role role = new Role();
		role.setId(rs.getInt("role_id"));
		role.setRoleName(rs.getString("role_name"));
		role.setDescription(rs.getString("description"));
		return role;
	}	
}