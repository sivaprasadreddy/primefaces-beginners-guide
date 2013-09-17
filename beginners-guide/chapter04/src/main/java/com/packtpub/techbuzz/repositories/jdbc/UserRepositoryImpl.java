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
	public User login(String emailId, String pwd)
	{
		String sql = "SELECT * FROM USERS  WHERE EMAIL_ID=? AND PASSWORD=? AND (DISABLED IS NULL OR DISABLED=0)";
		Object[] args = new Object[]{emailId, pwd};
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
	public User createUser(final User user)
	{
		final String sql = "INSERT INTO USERS (EMAIL_ID,PASSWORD,FIRSTNAME,LASTNAME,GENDER,PHONE,DOB,DISABLED,BIO)"+
				 	 		" VALUES (?,?,?,?,?,?,?,?,?);";
		
		KeyHolder holder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {           
                @Override
                public PreparedStatement createPreparedStatement(Connection connection)
                        throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, user.getEmailId());
                    ps.setString(2, user.getPassword());
                    ps.setString(3, user.getFirstName());
                    ps.setString(4, user.getLastName());
                    ps.setString(5, user.getGender());
                    ps.setString(6, user.getPhone());
                    if(user.getDob() != null)
                    {
                    	ps.setDate(7, new java.sql.Date(user.getDob().getTime()));
                    }else {
                    	ps.setDate(7, null);
                    }
                    ps.setBoolean(8, user.getDisabled());
                    ps.setString(9, user.getBio());
                    return ps;
                }
            }, holder);

		int newUserId = holder.getKey().intValue();
		user.setId(newUserId);
		return user;
	}
	
	@Override
	public int changePassword(String emailId, String oldPwd, String newPwd) {
		String sql = "UPDATE USERS SET PASSWORD=? WHERE EMAIL_ID=? AND PASSWORD=?";
		Object[] args = new Object[]{newPwd,emailId,oldPwd};
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public User update(User user) {
		final String sql = "UPDATE USERS SET FIRSTNAME=?,LASTNAME=?,GENDER=?,PHONE=?,DOB=?,DISABLED=?, BIO=? WHERE EMAIL_ID=?";
		
		Object[] args = {
				user.getFirstName(),
				user.getLastName(),
				user.getGender(),
				user.getPhone(),
				user.getDob(),
				user.getDisabled(),
				user.getBio(),
				user.getEmailId()
		};
		jdbcTemplate.update(sql, args);
		
		return user;
	}

	@Override
	public List<User> findAllUsers() {
		String sql = "SELECT * FROM USERS";
		List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
		return users;
	}
}

class UserRowMapper implements RowMapper<User>
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
		user.setGender(rs.getString("gender"));
		user.setPhone(rs.getString("phone"));
		user.setDob(rs.getDate("dob"));
		user.setDisabled(rs.getBoolean("disabled"));
		user.setBio(rs.getString("bio"));
		return user;
	}
	
}
