package com.packtpub.techbuzz.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.packtpub.techbuzz.entities.User;
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
		String sql = "SELECT * FROM USERS  WHERE (USERNAME=? OR EMAIL_ID=?) AND PASSWORD=? AND (DISABLED IS NULL OR DISABLED=0)";
		Object[] args = new Object[]{loginId,loginId, pwd};
		List<User> users = jdbcTemplate.query(sql, args, new UserRowMapper());
		if(users != null && !users.isEmpty()){
			return users.get(0);
		}
		return null;
	}

	@Override
	public User findByUserName(String userName)
	{
		String sql = "SELECT * FROM USERS WHERE USERNAME=?";
		Object[] args = new Object[]{userName};
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
		final String sql = "INSERT INTO USERS (EMAIL_ID,PASSWORD,FIRSTNAME,LASTNAME,PHONE,DOB,DISABLED)"+
				 	 		" VALUES (?,?,?,?,?,?,?);";
		
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
                    ps.setString(5, user.getPhone());
                    if(user.getDob() != null)
                    {
                    	ps.setDate(6, new java.sql.Date(user.getDob().getTime()));
                    }else {
                    	ps.setDate(6, null);
                    }
                    ps.setBoolean(7, user.getDisabled());
                    return ps;
                }
            }, holder);

		int newUserId = holder.getKey().intValue();
		user.setId(newUserId);
		return user;
	}
	
	@Override
	public int changePassword(String loginId, String oldPwd, String newPwd) {
		String sql = "UPDATE USERS SET PASSWORD=? WHERE (EMAIL_ID=? OR USERNAME=?) AND PASSWORD=?";
		Object[] args = new Object[]{newPwd, loginId, loginId, oldPwd};
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public User create(User t) {
		return null;
	}

	@Override
	public User findById(Integer key) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return null;
	}

	@Override
	public void update(User t) {
		
	}

	@Override
	public void delete(Integer key) {
		
	}

}


