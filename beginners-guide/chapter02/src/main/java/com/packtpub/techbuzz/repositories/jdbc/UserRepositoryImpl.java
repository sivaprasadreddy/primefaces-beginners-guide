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

import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User login(String userName, String pwd)
	{
		String sql = "SELECT * FROM USERS  WHERE USERNAME=? AND PASSWORD=? AND (DISABLED IS NULL OR DISABLED=0)";
		Object[] args = new Object[]{userName, pwd};
		List<User> users = jdbcTemplate.query(sql, args, new UserRowMapper());
		if(users != null && !users.isEmpty()){
			return users.get(0);
		}
		return null;
	}

	@Override
	public User findByEmailId(String email)
	{
		String sql = "SELECT * FROM USERS WHERE EMAIL_ID=?";
		Object[] args = new Object[]{email};
		List<User> users = jdbcTemplate.query(sql, args, new UserRowMapper());
		if(users != null && !users.isEmpty()){
			return users.get(0);
		}
		return null;
	}

	@Override
	public User findByUserName(String userName)
	{
		String sql = "SELECT * FROM USERS  WHERE USERNAME=?";
		Object[] args = new Object[]{userName};
		List<User> users = jdbcTemplate.query(sql, args, new UserRowMapper());
		if(users != null && !users.isEmpty()){
			return users.get(0);
		}
		return null;
	}

	@Override
	public User createUser(final User user)
	{
		final String sql = "INSERT INTO USERS (USERNAME,PASSWORD,FIRSTNAME,LASTNAME,EMAIL_ID,PHONE,DOB,DISABLED)"+
				 	 		" VALUES (?,?,?,?,?,?,?,?);";
		
		KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {           
                @Override
                public PreparedStatement createPreparedStatement(Connection connection)
                        throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, user.getUserName());
                    ps.setString(2, user.getPassword());
                    ps.setString(3, user.getFirstName());
                    ps.setString(4, user.getLastName());
                    ps.setString(5, user.getEmailId());
                    ps.setString(6, user.getPhone());
                    ps.setDate(7, new java.sql.Date(user.getDob().getTime()));
                    ps.setBoolean(8, user.getDisabled());
                    return ps;
                }
            }, holder);

		int newUserId = holder.getKey().intValue();
		user.setId(newUserId);
		return user;
	}
	
	@Override
	public int changePassword(String userName, String oldPwd, String newPwd) {
		String sql = "UPDATE USERS SET PASSWORD=? WHERE USERNAME=? AND PASSWORD=?";
		Object[] args = new Object[]{newPwd,userName,oldPwd};
		return jdbcTemplate.update(sql, args);
	}
}

class UserRowMapper implements RowMapper<User>
{
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		User user = new User();
		user.setId(rs.getInt("user_id"));
		user.setUserName(rs.getString("userName"));
		user.setPassword(rs.getString("password"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setEmailId(rs.getString("email_Id"));
		user.setPhone(rs.getString("phone"));
		user.setDob(rs.getDate("dob"));
		user.setDisabled(rs.getBoolean("disabled"));		
		return user;
	}
	
}
