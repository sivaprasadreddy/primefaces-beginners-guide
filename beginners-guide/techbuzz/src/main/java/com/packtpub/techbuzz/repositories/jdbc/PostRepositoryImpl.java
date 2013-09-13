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

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.repositories.PostRepository;
import com.packtpub.techbuzz.repositories.rowmappers.PostRowMapper;

/**
 * @author Siva
 *
 */
@Repository
public class PostRepositoryImpl implements PostRepository
{
	@Autowired 
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Post> findAll()
	{
		String FIND_ALL_POSTS_SQL = "select * from posts";
		return jdbcTemplate.query(FIND_ALL_POSTS_SQL, new PostRowMapper());
	}

	@Override
	public List<Post> findPostsByUserId(Integer userId)
	{
		String FIND_POSTS_BY_USER_SQL = "select * from posts where posted_by=?";
		return jdbcTemplate.query(FIND_POSTS_BY_USER_SQL, 
				new Object[]{userId}, new PostRowMapper());
	}

	@Override
	public Post findById(Integer postId)
	{
		String FIND_POST_SQL = "select * from posts where post_id=?";
		List<Post> posts = jdbcTemplate.query(FIND_POST_SQL, 
					new Object[]{postId}, new PostRowMapper());
		if(posts != null && !posts.isEmpty())
		{
			return posts.get(0);
		}
		return null;
	}

	@Override
	public Post create(final Post post)
	{
		final String INSERT_SQL = "INSERT INTO posts (title, description, posted_by, created_on) VALUES (?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
			    new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			            PreparedStatement ps =
			                connection.prepareStatement(INSERT_SQL, new String[] {"post_id"});
			            	ps.setString(1, post.getTitle());
			            	ps.setString(2, post.getDescription());
			            	ps.setInt(3, post.getUserId());
			            	ps.setDate(4, new java.sql.Date(post.getCreatedOn().getTime()));
			            return ps;
			        }
			    },
			    keyHolder);

		Number key = keyHolder.getKey();
		post.setId(key.intValue());
		return post;
	}

	@Override
	public void update(Post post) {
		String UPDATE_SQL = "UPDATE posts SET title = ?, description = ? WHERE post_id = ?";
		jdbcTemplate.update(UPDATE_SQL, new Object[]{post.getTitle(), post.getDescription(), post.getId()});
	}

	@Override
	public void delete(Integer postId) {
		String DELETE_SQL = "delete from posts where post_id=?";
		jdbcTemplate.update(DELETE_SQL, new Object[]{postId});
	}

	@Override
	public List<Post> searchPosts(String query) {
		String SEARCH_SQL = "select * from posts where title like ? or description like ?";
		return jdbcTemplate.query(SEARCH_SQL,
				new Object[]{"%"+query+"%","%"+query+"%"},
				new PostRowMapper());
	}
	
}

