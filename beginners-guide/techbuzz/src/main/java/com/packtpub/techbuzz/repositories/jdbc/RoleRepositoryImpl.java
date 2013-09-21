package com.packtpub.techbuzz.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.packtpub.techbuzz.entities.Role;
import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.repositories.RoleRepository;
import com.packtpub.techbuzz.repositories.rowmappers.RoleRowMapper;

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
	public Role create(final Role role)
	{
		final String INSERT_SQL = "INSERT INTO roles (role_name, description) VALUES (?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
			    new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			            PreparedStatement ps =
			                connection.prepareStatement(INSERT_SQL, new String[] {"role_id"});
			            	ps.setString(1, role.getRoleName());
			            	ps.setString(2, role.getDescription());
			            return ps;
			        }
			    },
			    keyHolder);

		Number key = keyHolder.getKey();
		role.setId(key.intValue());
		return role;
	}
	
	public void insertUserRole(int userId, int roleId)
	{
		final String INSERT_SQL = "INSERT INTO users_roles (user_id, role_id) VALUES (?, ?)";
		jdbcTemplate.update(INSERT_SQL, new Object[]{userId, roleId});
	}

	@Override
	public Role findById(Integer roleId)
	{
		String sql = "SELECT * FROM ROLES WHERE ROLE_ID=?";
		List<Role> roles = jdbcTemplate.query(sql, new Object[]{roleId}, new RoleRowMapper());
		if(!roles.isEmpty()){
			return roles.get(0);
		}
		return null;
	}
	
	@Override
	public List<Role> findUserRoles(Integer userId)
	{
		String sql = "SELECT r.* FROM roles r join users_roles ur on r.role_id=ur.role_id where ur.user_id=?";
		List<Role> roles = jdbcTemplate.query(sql, new Object[]{userId}, new RoleRowMapper());
		return roles;
	}

	@Override
	public List<Role> findAll()
	{
		String sql = "SELECT * FROM ROLES";
		List<Role> roles = jdbcTemplate.query(sql, new RoleRowMapper());
		return roles;
	}

	@Override
	public void update(Role t)
	{
		
	}

	@Override
	public void delete(Integer roleId)
	{
		String DELETE_SQL = "delete from roles where role_id=?";
		jdbcTemplate.update(DELETE_SQL, new Object[]{roleId});
	}

	@Override
	public void updateUserRoles(User user)
	{
		String DELETE_USER_ROLES_SQL = "delete from users_roles where user_id=?";
		jdbcTemplate.update(DELETE_USER_ROLES_SQL, new Object[]{user.getId()});
		List<Role> roles = user.getRoles();
		for (Role role : roles)
		{
			insertUserRole(user.getId(), role.getId());
		}
	}
	
}


