package com.packtpub.techbuzz.repositories.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
		return jdbcTemplate.query("select * from posts", new PostRowMapper());
	}

	@Override
	public List<Post> findPostsByUserId(Integer userId)
	{
		return null;
	}

	@Override
	public Post findById(Integer PostId)
	{
		return null;
	}

	@Override
	public Post create(Post post)
	{
		return null;
	}

	@Override
	public void update(Post t) {
		
	}

	@Override
	public void delete(Integer key) {
		
	}

	@Override
	public List<Post> searchPosts(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

