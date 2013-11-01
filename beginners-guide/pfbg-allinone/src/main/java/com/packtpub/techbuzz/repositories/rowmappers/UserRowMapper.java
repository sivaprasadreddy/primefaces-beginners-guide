/**
 * 
 */
package com.packtpub.techbuzz.repositories.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.packtpub.techbuzz.entities.User;

/**
 * @author skatam
 *
 */
public class UserRowMapper implements RowMapper<User>
{
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		User user = new User();
		user.setId(rs.getInt("user_id"));
		user.setEmailId(rs.getString("email_Id"));
		user.setPassword(rs.getString("password"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setPhone(rs.getString("phone"));
		user.setDob(rs.getDate("dob"));
		user.setGender(rs.getString("gender"));
		user.setBio(rs.getString("bio"));
		user.setDisabled(rs.getBoolean("disabled"));
		return user;
	}	
}