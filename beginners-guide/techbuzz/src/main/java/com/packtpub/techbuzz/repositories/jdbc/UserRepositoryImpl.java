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
import com.packtpub.techbuzz.entities.UserSettings;
import com.packtpub.techbuzz.repositories.UserRepository;
import com.packtpub.techbuzz.repositories.rowmappers.UserRowMapper;

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
	public User login(String loginId, String pwd)
	{
		String sql = "SELECT * FROM USERS  WHERE EMAIL_ID=? AND PASSWORD=? AND (DISABLED IS NULL OR DISABLED=0)";
		Object[] args = new Object[]{loginId, pwd};
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
	public User create(final User user)
	{
		final String sql = "INSERT INTO USERS (EMAIL_ID,PASSWORD,FIRSTNAME,LASTNAME,GENDER,PHONE,DOB,BIO,DISABLED)"+
				 	 		" VALUES (?,?,?,?,?,?,?,?,?)";
		
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
                    ps.setString(8, user.getBio());
                    ps.setBoolean(9, user.getDisabled());
                    return ps;
                }
            }, holder);

		int newUserId = holder.getKey().intValue();
		user.setId(newUserId);
		return user;
	}
	
	@Override
	public int changePassword(String loginId, String oldPwd, String newPwd) {
		String sql = "UPDATE USERS SET PASSWORD=? WHERE EMAIL_ID=? AND PASSWORD=?";
		Object[] args = new Object[]{newPwd, loginId, oldPwd};
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public void update(User user) {
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
		
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM USERS";
		List<User> users = jdbcTemplate.query(sql, new UserRowMapper());
		return users;
	}
	
	@Override
	public User findById(Integer key) {
		String sql = "SELECT * FROM USERS WHERE USER_ID=?";
		List<User> users = jdbcTemplate.query(sql, new Object[]{key}, new UserRowMapper());
		if(!users.isEmpty()){
			return users.get(0);
		}
		return null;
	}



	@Override
	public void delete(Integer key) {
		
	}

	@Override
	public void updateUsersStatus(List<User> users, String status) {
		final String sql = "UPDATE USERS SET DISABLED=? WHERE EMAIL_ID=?";
		boolean disabled = (status != null && "DISABLED".equalsIgnoreCase(status));
		for (User user : users) 
		{
			Object[] args = {					
					disabled,					
					user.getEmailId()
			};
			jdbcTemplate.update(sql, args);
		}
				
	}

	@Override
	public void insertUserSettings(UserSettings settings)
	{
		
		String SQL = "insert into user_settings(user_id, theme, receive_email_feed) values(?,?,?)";
		jdbcTemplate.update(SQL, new Object[]{
				settings.getUserId(),
				settings.getTheme(),
				settings.isReceiveEmailFeed()
		});
	}
	
	@Override
	public void updateUserSettings(UserSettings settings)
	{
		
		String SQL = "update user_settings set theme=?, receive_email_feed=? where user_id=? ";
		jdbcTemplate.update(SQL, new Object[]{
				settings.getTheme(),
				settings.isReceiveEmailFeed(),
				settings.getUserId()
		});
	}

	@Override
	public UserSettings getUserSettings(int userId)
	{
		String sql = "select * from user_settings where user_id=?";
		List<UserSettings> results = jdbcTemplate.query(sql, new Object[]{userId}, new RowMapper<UserSettings>(){

			@Override
			public UserSettings mapRow(ResultSet rs, int rowNum)
					throws SQLException
			{
				UserSettings settings = new UserSettings();
				settings.setUserId(rs.getInt("user_id"));
				settings.setTheme(rs.getString("theme"));
				settings.setReceiveEmailFeed(rs.getBoolean("receive_email_feed"));
				
				return settings;
			}
			
		});
		if(results!= null && !results.isEmpty()){
			return results.get(0);
		}
		return null;
	}

}


