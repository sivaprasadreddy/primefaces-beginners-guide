package com.packtpub.techbuzz.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.packtpub.techbuzz.entities.Role;
import com.packtpub.techbuzz.repositories.RoleRepository;

/**
 * @author Siva
 *
 */
@Repository
public class RoleRepositoryImpl implements RoleRepository
{
	@Autowired 
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Role> findAllRoles() {
		return jdbcTemplate.query("select * from roles", new RoleMapper());
	}

	@Override
	public Role getRole(Integer roleId) {
		List<Role> roles = jdbcTemplate.query("select * from roles where role_id=?", new Object[]{roleId}, new RoleMapper());
		if(roles != null && !roles.isEmpty()){
			return roles.get(0);
		}
		return null;
	}

	@Override
	public Role createRole(final Role role) 
	{
		final String sql = "INSERT INTO ROLES (role_name, description) VALUES (?,?)";
		KeyHolder holder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {           
		    @Override
		    public PreparedStatement createPreparedStatement(Connection connection)
		            throws SQLException {
		        PreparedStatement ps = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
		        ps.setString(1, role.getRoleName());
		        ps.setString(2, role.getDescription());
		        		        
		        return ps;
		    }
		}, holder);
		
		int newRoleId = holder.getKey().intValue();
		role.setId(newRoleId);
		return role;
	}
	
}

class RoleMapper implements RowMapper<Role>{

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

