package com.packtpub.techbuzz.repositories.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.repositories.BuzzRepository;

/**
 * @author Siva
 *
 */
@Repository
public class BuzzRepositoryImpl implements BuzzRepository
{
	@Autowired 
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Post> findAllPosts()
	{
		return jdbcTemplate.query("select * from posts", new PostMapper());
	}

	@Override
	public List<Post> findPostsByUserId(Integer userId)
	{
		return null;
	}

	@Override
	public Post getPost(Integer PostId)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tag> findByLabelStartingWith(String query)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post createPost(Post post)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tag> findAllTags()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}

class PostMapper implements RowMapper<Post>{

	@Override
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Post post = new Post();
		post.setId(rs.getInt("post_id"));
		post.setTitle(rs.getString("title"));
		post.setDescription(rs.getString("description"));
		post.setPostedBy(new User(rs.getInt("posted_by")));
		post.setCreatedOn(rs.getDate("created_on"));
		return post;
	}
	
}
